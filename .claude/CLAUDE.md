# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

YetAnotherHueApi is a Java 17 library for controlling Philips Hue lights via the REST API of the Philips Hue Bridge. It provides a modern, intuitive API without using the official Hue SDK.

## Development Commands

### Build and Test
- `mvn clean compile` - Compile the project
- `mvn test` - Run all unit tests
- `mvn clean install` - Build, test, and install to local Maven repository
- `mvn surefire:test -Dtest=SpecificTestClass` - Run a single test class
- `mvn surefire:test -Dtest=SpecificTestClass#testMethod` - Run a single test method

### Package and Deploy
- `mvn package` - Create JAR file
- `mvn source:jar javadoc:jar` - Generate source and javadoc JARs
- `mvn release:prepare release:perform` - Prepare and perform a release (requires GPG signing)

## Architecture Overview

### Package Structure
- `io.github.zeroone3010.yahueapi` - Legacy API (v1) classes for backward compatibility
- `io.github.zeroone3010.yahueapi.v2` - Modern API (v2) implementation using Philips Hue API v2
  - Main entry point: `Hue` class
  - Factory classes for creating domain objects (LightFactory, GroupFactory, etc.)
  - Implementation classes (*Impl) for domain interfaces
- `io.github.zeroone3010.yahueapi.v2.domain` - Domain objects representing Hue API resources
  - Resource classes for API responses
  - `update` subpackage for update/command objects
- `io.github.zeroone3010.yahueapi.discovery` - Bridge discovery functionality (mDNS, N-UPnP)

### Key Design Patterns
- Factory pattern for creating domain objects from API responses
- Builder pattern for connection initialization (`HueBridgeConnectionBuilder`)
- Optional-based API for null safety
- Immutable domain objects with separate update/command objects

### External Dependencies
- Jackson for JSON processing
- OkHttp for HTTP/HTTPS connections and Server-Sent Events
- SLF4J for logging (implementation provided by consumer)
- JUnit 5 and WireMock for testing

## Code Conventions

### Java Style
- Java 17 features (records, var, text blocks, enhanced switch expressions)
- 2-space indentation (4 spaces for XML files)
- No wildcard imports
- Descriptive variable names
- Final variables where values don't change
- `@Override` annotation on all overridden methods
- No empty catch blocks
- Use `var` for local variables where type is obvious
- Convert immutable data classes to records where appropriate

### Testing Requirements
- Write tests for all new functionality
- Test classes should mirror the package structure
- Use descriptive test method names
- Mock external dependencies using WireMock

### Commit Guidelines
- Present tense, capitalized messages ("Add support for X", not "Added support for x")
- Reference issues when applicable ("#123")
- Small, focused commits (avoid "and" in messages)
- Use squash/amend for fixing review comments

## Important Implementation Details

### HTTPS Connection
- Uses HTTPS by default (required by Philips Hue bridges)
- Custom trust manager for self-signed Hue bridge certificates
- Certificate validation in `SelfSignedHueBridgeCertificateAcceptingTrustManager`

### API Key Management
- API keys obtained via `HueBridgeConnectionBuilder.initializeApiConnection()`
- User must press bridge button during initialization
- Keys should be stored securely by the consuming application

### Event Streaming
- Server-Sent Events (SSE) for real-time updates
- Uses LaunchDarkly's eventsource library
- Event handlers implement `HueEventListener` interface
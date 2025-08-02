# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

huevana is a Java 17 library for controlling Philips Hue lights via the Bridge REST API. The project provides both legacy v1 API support (deprecated) and modern v2 API functionality for comprehensive Hue ecosystem interaction.

## Key Architecture Components

### Core API Structure
- **Main Entry Point**: `v2.io.github.greenstevester.heuvana.Hue` - Primary class for initializing and managing Bridge connections
- **Bridge Discovery**: `discovery.io.github.greenstevester.heuvana.HueBridgeDiscoveryService` - Automatic Bridge discovery via N-UPnP and mDNS
- **Connection Builder**: `io.github.greenstevester.heuvana.HueBridgeConnectionBuilder` - Handles API key initialization and HTTPS setup

### Device Abstraction Layer
The library uses factory patterns for device creation:
- **LightFactory**: Creates Light objects from LightResource data
- **SwitchFactory**: Creates Switch objects (dimmer switches, tap switches, etc.)
- **GroupFactory**: Creates Group objects for rooms and zones
- **MotionSensorFactory**: Creates motion sensor objects
- **TemperatureSensorFactory**: Creates temperature sensor objects

### Resource Management
- **ResourceRoot**: Contains all Bridge resources retrieved from `/clip/v2/resource`
- **Domain Objects**: Located in `v2.domain` package, represent different Bridge resource types
- **Factory Pattern**: Each device type has a dedicated factory for object creation

### Security & HTTPS
- **SecureJsonFactory**: Handles self-signed certificate trust for Bridge HTTPS connections
- **SelfSignedHueBridgeCertificateAcceptingTrustManager**: Custom trust manager for Bridge certificates

## Common Development Commands

### Build Commands
```bash
# Compile the project
mvn compile

# Run all tests
mvn test

# Run a specific test class
mvn test -Dtest=ColorTest

# Package the library
mvn package

# Install to local repository
mvn install

# Generate sources and javadoc JARs
mvn source:jar javadoc:jar
```

### Testing Commands
```bash
# Run tests with verbose output
mvn test -X

# Run integration tests (TestRun classes)
mvn test -Dtest="*TestRun"

# Run unit tests only (exclude TestRun classes)
mvn test -Dtest="*Test" -Dtest="!*TestRun"
```

### Release Commands
```bash
# Prepare release
mvn release:prepare

# Perform release
mvn release:perform

# Deploy to staging
mvn deploy
```

## Package Structure

### Main Source (`src/main/java/io/github/greenstevester/yahueapi/`)
- **Root Package**: Core classes (Color, HueBridge, HueBridgeConnectionBuilder)
- **v2/**: Modern API implementation (Hue class, Light, Group, Switch, Sensors)
- **v2/domain/**: Resource data classes and update objects
- **discovery/**: Bridge discovery implementations (N-UPnP, mDNS)

### Test Source (`src/test/java/io/github/greenstevester/yahueapi/`)
- **Unit Tests**: Classes ending with `Test` (e.g., ColorTest, MathUtilTest)
- **Integration Tests**: Classes ending with `TestRun` (require actual Bridge hardware)
- **Markdown Tests**: Verify README code examples work correctly

## Development Patterns

### Resource Refresh Pattern
The main Hue class maintains cached resource maps that are refreshed from the Bridge:
```java
// Triggers refresh of lights, switches, sensors, groups
hue.refresh();
```

### Factory Method Pattern
Device objects are created through factories to handle complex resource relationships:
```java
LightImpl light = lightFactory.buildLight(lightResource, resourceUrl);
```

### Optional-based APIs
Most lookup methods return Optional to handle missing resources gracefully:
```java
Optional<Group> room = hue.getRoomByName("Living Room");
Optional<Light> light = room.flatMap(r -> r.getLightByName("Ceiling"));
```

### Event Streaming
Uses LaunchDarkly EventSource for real-time Bridge events:
```java
HueEventSource eventSource = hue.subscribeToEvents(eventListener);
```

## Testing Guidelines

### Unit Tests
- Test core functionality without requiring Bridge hardware
- Mock HTTP responses using WireMock for network interactions
- Focus on business logic, color conversion, and data parsing

### Integration Tests (TestRun)
- Require actual Philips Hue Bridge hardware
- Test real Bridge communication and state changes
- Manual execution only - not part of automated CI/CD

### Test Resource Files
Located in `src/test/resources/`:
- JSON response examples for different Bridge configurations
- Certificate files for HTTPS testing

## Dependencies

### Core Runtime Dependencies
- **Jackson**: JSON parsing and HTTP communication
- **OkHttp EventSource**: Real-time event streaming from Bridge
- **SLF4J**: Logging framework

### Test Dependencies
- **JUnit 5**: Testing framework with parameterized test support
- **WireMock**: HTTP service mocking for unit tests

## Build Configuration Notes

- **Java Version**: Requires Java 17 (configured in compiler plugin)
- **Encoding**: UTF-8 source encoding
- **Packaging**: Standard JAR with sources and javadoc JARs
- **Distribution**: Maven Central via Nexus staging plugin
- **Signing**: GPG signing for releases

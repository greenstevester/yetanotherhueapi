# Security Policy

## Supported Versions

We provide security updates for the following versions of huevana:

| Version | Supported          |
| ------- | ------------------ |
| 4.x.x   | :white_check_mark: |
| 3.x.x   | :white_check_mark: |
| < 3.0   | :x:                |

## Reporting a Vulnerability

If you discover a security vulnerability in huevana, please report it responsibly:

### How to Report

1. **DO NOT** create a public GitHub issue for security vulnerabilities
2. Email the maintainer directly at: steve@greensill.net
3. Include the following information:
   - Description of the vulnerability
   - Steps to reproduce the issue
   - Potential impact
   - Any suggested fixes

### What to Expect

- **Initial Response**: You will receive an acknowledgment within 48 hours
- **Status Updates**: We will provide regular updates on our progress
- **Timeline**: We aim to release security fixes within 30 days of confirmed vulnerabilities
- **Credit**: With your permission, we will acknowledge your contribution in the security advisory

### Security Best Practices

When using huevana:

1. **Use HTTPS**: Always connect to Hue Bridges using HTTPS (default since v2.5.0)
2. **Validate Certificates**: Be cautious when accepting self-signed certificates
3. **Secure Storage**: Store bridge connection tokens securely
4. **Network Security**: Ensure your network connection to the bridge is secure
5. **Update Regularly**: Keep the library updated to the latest version
6. **Input Validation**: Validate all inputs when building applications

### Known Security Considerations

1. **Self-Signed Certificates**: The library includes functionality to accept self-signed certificates from Hue Bridges. This is necessary for communication but should be used carefully.

2. **Token Storage**: The library does not provide built-in secure storage for authentication tokens. Applications should implement secure token storage.

3. **Network Communication**: Communication with Hue Bridges occurs over your local network. Ensure your network is secure.

### Security Scanning

This repository includes automated security scanning:

- **CodeQL**: Static analysis for code vulnerabilities
- **OWASP Dependency Check**: Scans for known vulnerabilities in dependencies
- **Trivy**: Secrets detection and additional vulnerability scanning

Security scans are run:
- On every push to main and develop branches
- On all pull requests
- Daily via scheduled workflows

### Responsible Disclosure

We follow responsible disclosure practices:

1. Security issues are investigated privately
2. Fixes are developed and tested before public disclosure
3. Security advisories are published with appropriate details
4. We coordinate with reporters on disclosure timing

### Security Contact

For security-related questions or concerns:
- Email: steve@greensill.net
- GPG Key: Available on request

Thank you for helping keep huevana secure!

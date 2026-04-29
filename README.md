# CreateNewAccountTesting

This project is a Maven-based Java test project for validating a **Create New Account** form workflow.

## Tech Stack

- Java 17
- Maven
- JUnit 5
- GitHub Actions

## Project Structure

```text
CreateNewAccountTesting/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── AccountValidator.java
│   └── test/
│       └── java/
│           └── AccountValidatorTest.java
├── .github/
│   └── workflows/
│       └── ci.yml
├── pom.xml
└── README.md
```

## Validation Scope

`AccountValidator` checks:

- First Name / Last Name (not blank, valid length)
- Email format
- Birth date boundaries (age between 18 and 120)
- Password strength:
  - minimum 8 characters
  - at least 1 uppercase letter
  - at least 1 lowercase letter
  - at least 1 digit
  - at least 1 special character
- Confirm password equality

## Test Design

Tests were created using:

- Equivalence Partitioning
- Boundary Value Analysis

Current suite includes **21 JUnit tests** covering valid and invalid scenarios.

## Run Tests Locally

```bash
mvn test
```

## CI (GitHub Actions)

CI workflow file: `.github/workflows/ci.yml`

On every `push` and `pull_request`, GitHub Actions:

1. Checks out repository
2. Sets up JDK 17
3. Runs `mvn -B test`


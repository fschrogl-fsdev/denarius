# Coinmaster

A WebApp mainly designed for tracking daily expenses. Based on Spring Boot, Bootstrap and AngularJS.

## Requirements

- Java 11+
- PostgreSQL 10.6+

## Getting started

This application is implemented using Spring Boot framework, hence it is a self-contained JAR file application. It can
be started using the Spring Boot Maven Plugin's run goal:

```bash
mvn -pl coinmaster-web -am spring-boot:run
```

Or by creating the application's Spring Boot JAR and starting it directly from the command line:

```bash
mvn clean install
java -jar coinmaster-web/target/coinmaster-web-X.Y.Z.jar
```

## How to develop

When developing the application make sure to activate Maven profile ``development`` and also Spring profile
``development``. The Maven profile takes care of including Spring Boots DevTools to the project's dependencies and
the Spring profiles configures the application for development purposes, i.e. using an in-memory database.

```bash
mvn -P development -pl coinmaster-web -am spring-boot:run --spring.profiles.active=development
```
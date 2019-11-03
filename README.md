# Coinmaster

A WebApp mainly designed for tracking daily expenses. Based on Spring Boot, Mini.css and AngularJS.

## Requirements

- Java 11+
- PostgreSQL 10.6+

## How to start

This application is implemented using Spring Boot framework, hence it is a self-contained JAR file application. It can
be started using the Spring Boot Maven Plugin's run goal:

```bash
mvn -pl coinmaster-web spring-boot:run
```

Or by creating the application's Spring Boot JAR and starting it directly from the command line:

```bash
mvn clean install
java -jar coinmaster-web/target/coinmaster-web-X.Y.Z.jar
```
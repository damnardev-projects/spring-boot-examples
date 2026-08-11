# Spring Boot Examples

This project contains a collection of Spring Boot examples.

## Structure

- **root**:
    - `build.gradle` — SonarQube and JaCoCo aggregation configuration.
    - `settings.gradle` — declares the project modules.
- **gradle/libs.versions.toml** — version catalog for dependencies and plugins.
- **buildSrc/** — shared build logic implemented as convention plugins:
    - `common-conventions` — applies the `java` plugin and `io.spring.dependency-management` plugin, sets the Java 21
      toolchain, configures JUnit Platform, and adds Spring Boot BOM platform dependency.
    - `library-conventions` — extends `common-conventions` for library modules.
    - `application-conventions` — extends `common-conventions`, applies the `application` plugin and
      `org.springframework.boot` plugin for runnable Spring Boot applications.
- **projects/** — all spring boot examples
- **build/** — compiled outputs and generated reports.

## Useful Commands

Use the included Gradle wrapper (`gradlew` / `gradlew.bat`) to ensure all developers use the same Gradle version.

- `./gradlew clean` : removes generated files
- `./gradlew build` : compiles, tests, and assembles all artifacts

## Examples

1. `Spring Command Line Runner` is a simple Spring Boot application which start the context and execute a
   `CommandLineRunner` to print messages.
    - `./gradlew :projects:command-line-runner:bootRun` : runs the Command Line Runner application
    - `./gradlew :projects:command-line-runner:bootRun --args="Foo Bar"` : runs the Command Line Runner application with
      arguments

2. `Application Runner` is a simple Spring Boot application which start the context and execute an `ApplicationRunner`
   to print messages.
    - `./gradlew :projects:application-runner:bootRun` : runs the Application Runner application
    - `./gradlew :projects:application-runner:bootRun --args="Foo -d --debug --other=Bar"` : runs the Application Runner
      application with arguments

3. `Spring Value Annotation` is a simple Spring Boot application which demonstrates the use of the `@Value` annotation
   to inject properties.
    - `./gradlew :projects:value-annotation:bootRun` : runs the Spring Value Annotation application

4. `Spring Scheduled Annotation`is a simple Spring Boot application which demonstrates the use of the `@Scheduled` annotation to schedule tasks (e.g., fixed rate, fixed delay, cron).
    - `./gradlew :projects:scheduled-annotation:bootRun` : runs the Spring Scheduled Annotation application

5. `Spring Configuration Properties` is a simple Spring Boot application which demonstrates the use of the
   `@ConfigurationProperties` annotation to map properties to a Java record instead of using `@Value`.
    - `./gradlew :projects:configuration-properties:bootRun` : runs the Spring Configuration Properties application
# Spring Configuration Properties

A simple Spring Boot application which demonstrates the use of the `@ConfigurationProperties` annotation, enabled with `@EnableConfigurationProperties`, to bind properties to a Java record instead of using `@Value`.

## Running the Application

```bash
./gradlew :projects:core:configuration-properties:bootRun

# Override a property (command line argument, highest priority)
./gradlew :projects:core:configuration-properties:bootRun --args="--app.stage=production"

# Override with an environment variable (relaxed binding)
APP_STAGE=production APP_GREETING=hello ./gradlew :projects:core:configuration-properties:bootRun

# Override the nested retry policy (app.retry.max-retries)
APP_RETRY_MAX_RETRIES=5 ./gradlew :projects:core:configuration-properties:bootRun
```

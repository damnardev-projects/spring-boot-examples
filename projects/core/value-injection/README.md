# Spring Value Injection

A simple Spring Boot application which demonstrates the use of the `@Value` annotation to inject values.

## Running the Application

```bash
./gradlew :projects:core:value-injection:bootRun

# Override a property (command line argument, highest priority)
./gradlew :projects:core:value-injection:bootRun --args="--app.stage=production"

# Override with an environment variable
APP_STAGE=production APP_GREETING=hello ./gradlew :projects:core:value-injection:bootRun
```

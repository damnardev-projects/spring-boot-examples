# Application Runner

A simple Spring Boot application which starts the context and executes an `ApplicationRunner` to print messages.

## Running the Application

```bash
# Run the application
./gradlew :projects:application-runner:bootRun

# Run with arguments
./gradlew :projects:application-runner:bootRun --args="Foo -d --debug --other=Bar"
```

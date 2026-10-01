# Swagger WebFlux REST API Example

A simple Spring Boot application demonstrating a complete reactive REST API with interactive Swagger UI documentation.

## Run the application

The application uses an in-memory H2 database via R2DBC. No external database is required.

```bash
./gradlew :projects:web:swagger-webflux:bootRun
```

Once the server has started, visit Swagger UI at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) to explore and test the REST endpoints.

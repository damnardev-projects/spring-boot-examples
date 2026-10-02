# Scalar WebFlux REST API Example

A simple Spring Boot application demonstrating a complete reactive REST API with interactive Scalar documentation.

## Run the application

The application uses an in-memory H2 database via R2DBC. No external database is required.

```bash
./gradlew :projects:web:scalar-webflux:bootRun
```

Once the server has started, visit Scalar at [http://localhost:8080/scalar](http://localhost:8080/scalar) to explore and test the REST endpoints.

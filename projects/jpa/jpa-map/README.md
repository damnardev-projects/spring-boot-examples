# JPA Map Example

A Spring Boot application demonstrating how to map an employee's contact details as a `Map<ContactType, String>` with JPA `@ElementCollection`. The map keys (`EMAIL` and `PHONE`) are stored as strings in a separate table linked to the employee.

## Running the Application

```bash
./gradlew :projects:jpa:jpa-map:bootRun
```

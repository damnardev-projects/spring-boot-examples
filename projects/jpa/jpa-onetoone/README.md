# JPA One-to-One Example

A Spring Boot application demonstrating a one-to-one relationship between an employee and their details. Saving an employee also saves the associated details, and deleting an employee removes them. The relationship is fetched eagerly. The runner also updates the employee's details independently, without changing the employee.

## Running the Application

```bash
./gradlew :projects:jpa:jpa-onetoone:bootRun
```

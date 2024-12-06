# Description

Example of a REST controller using Spring Boot with basic authentication.

# How to execute

Run the following command:

```shell
mvn org.springframework.boot:spring-boot-maven-plugin:run
```

# How to test

Once the application is running, you can test it by calling the endpoints.

## Get all messages

```shell
curl -X GET http://localhost:8080/messages -u user:password
```

## Get a message by ID

```shell
curl -X GET http://localhost:8080/messages/1 -u user:password
```

## Create a message

```shell
curl -X POST http://localhost:8080/messages -u user:password -H 'Content-Type: application/json' -d '{"content": "Created message"}'
```

## Update a message

```shell
curl -X PUT http://localhost:8080/messages/1 -u user:password -H 'Content-Type: application/json' -d '{"content": "Updated message"}'
```

## Delete a message

```shell
curl -X DELETE http://localhost:8080/messages/1 -u user:password
```

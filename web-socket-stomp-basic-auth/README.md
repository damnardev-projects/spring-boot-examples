# Description

Example of a server that sends messages to a client using STOMP with Basic Auth.

# How to execute

Run the following command:

```shell
mvn -pl web-socket-stomp-basic-auth-server org.springframework.boot:spring-boot-maven-plugin:run
```

# How to test

```shell
mvn -pl web-socket-stomp-basic-auth-client org.springframework.boot:spring-boot-maven-plugin:run
```
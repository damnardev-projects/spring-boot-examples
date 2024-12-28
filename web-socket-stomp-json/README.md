# Description

Example of a server that sends JSON messages to a client using STOMP.

# How to execute

Run the following command:

```shell
mvn -pl web-socket-stomp-json-server org.springframework.boot:spring-boot-maven-plugin:run
```

# How to test

```shell
mvn -pl web-socket-stomp-json-client org.springframework.boot:spring-boot-maven-plugin:run
```
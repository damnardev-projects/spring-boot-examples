package fr.damnardev.example.springboot.rest.openapi.model;

import lombok.Builder;

@Builder
public record Message(long id, String content) {
}

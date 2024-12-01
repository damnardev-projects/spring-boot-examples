package fr.damnardev.example.springboot.rest.openapi.model;

import lombok.Builder;

@Builder
public record MessageForm(String content) {
}

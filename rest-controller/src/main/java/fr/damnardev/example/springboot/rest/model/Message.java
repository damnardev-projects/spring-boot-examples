package fr.damnardev.example.springboot.rest.model;

import lombok.Builder;

@Builder
public record Message(long id, String content) {
}

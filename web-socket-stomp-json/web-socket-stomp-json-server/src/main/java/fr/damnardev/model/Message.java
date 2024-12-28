package fr.damnardev.model;

import lombok.Builder;

@Builder
public record Message(long id, String content) {
}

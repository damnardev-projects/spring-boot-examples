package fr.damnardev.model;

import lombok.Builder;

@Builder
public record User(long id, String name) {
}

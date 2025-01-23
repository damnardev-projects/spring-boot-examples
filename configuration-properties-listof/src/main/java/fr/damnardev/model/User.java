package fr.damnardev.model;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record User(String name, LocalDate birthdate) {
}

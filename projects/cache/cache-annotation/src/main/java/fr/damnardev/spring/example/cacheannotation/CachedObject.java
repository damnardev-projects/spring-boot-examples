package fr.damnardev.spring.example.cacheannotation;

import java.time.Instant;

public record CachedObject(String id, String value, Instant createdAt) implements java.io.Serializable {
}

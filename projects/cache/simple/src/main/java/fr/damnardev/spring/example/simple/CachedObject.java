package fr.damnardev.spring.example.simple;

import java.io.Serializable;
import java.time.Instant;

public record CachedObject(String id, String value, Instant createdAt) implements Serializable {
}

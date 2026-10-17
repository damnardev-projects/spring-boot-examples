package fr.damnardev.spring.example.ehcache.minimal;

import java.io.Serializable;
import java.time.Instant;

public record CachedObject(String id, String value, Instant createdAt) implements Serializable {
}

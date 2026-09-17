package fr.damnardev.spring.example.cacheannotation;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

	private static final Logger logger = LoggerFactory.getLogger(CacheService.class);

	@Cacheable("objects")
	public CachedObject find(String id) {
		logger.info("Computing object {} (this takes 5 seconds)", id);
		sleepFiveSeconds();
		return new CachedObject(id, "Initial value", Instant.now());
	}

	@CachePut(cacheNames = "objects", key = "#id")
	public CachedObject update(String id, String value) {
		CachedObject updatedObject = new CachedObject(id, value, Instant.now());
		logger.info("Updated cached object: {}", updatedObject);
		return updatedObject;
	}

	@CacheEvict(cacheNames = "objects", key = "#id")
	public void evict(String id) {
		logger.info("Evicted cached object with id {}", id);
	}

	private void sleepFiveSeconds() {
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException exception) {
			Thread.currentThread()
			      .interrupt();
			throw new IllegalStateException("The cacheable operation was interrupted", exception);
		}
	}

}

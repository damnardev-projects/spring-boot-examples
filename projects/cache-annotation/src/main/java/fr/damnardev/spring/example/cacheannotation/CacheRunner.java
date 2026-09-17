package fr.damnardev.spring.example.cacheannotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CacheRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(CacheRunner.class);

	private final CacheService cacheService;

	public CacheRunner(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	@Override
	public void run(ApplicationArguments args) {
		String objectId = "example";

		this.logCall("First @Cacheable call", () -> this.cacheService.find(objectId));
		this.logCall("Second @Cacheable call", () -> this.cacheService.find(objectId));

		this.logCall("@CachePut call", () -> this.cacheService.update(objectId, "Updated value"));
		this.logCall("Read after @CachePut", () -> this.cacheService.find(objectId));

		this.cacheService.evict(objectId);
		this.logCall("Read after @CacheEvict", () -> this.cacheService.find(objectId));
	}

	private void logCall(String description, CacheOperation operation) {
		long startedAt = System.nanoTime();
		CachedObject object = operation.execute();
		long elapsedMilliseconds = (System.nanoTime() - startedAt) / 1_000_000;
		logger.info("{} returned {} in {} ms", description, object, elapsedMilliseconds);
	}

	@FunctionalInterface
	private interface CacheOperation {

		CachedObject execute();

	}

}

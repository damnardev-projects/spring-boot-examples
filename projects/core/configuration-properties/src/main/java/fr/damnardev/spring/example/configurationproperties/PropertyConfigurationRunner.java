package fr.damnardev.spring.example.configurationproperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PropertyConfigurationRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(PropertyConfigurationRunner.class);

	private final AppProperties firstAppProperties;

	private final AppProperties secondAppProperties;

	/*
	 * Constructor injection of AppProperties beans for first and second applications.
	 */
	public PropertyConfigurationRunner(
			@Qualifier("firstAppProperties") AppProperties firstAppProperties,
			@Qualifier("secondAppProperties") AppProperties secondAppProperties) {
		this.firstAppProperties = firstAppProperties;
		this.secondAppProperties = secondAppProperties;
	}

	private static void print(AppProperties appProperties) {
		logger.info("Application Name: {}", appProperties.name());
		logger.info("Application Version: {}", appProperties.version());
		logger.info("Environment: {}", appProperties.environment());
		logger.info("Server Port: {}", appProperties.port());
		logger.info("Debug Mode: {}", appProperties.debug());
		logger.info("Tags: {}", appProperties.tags());
	}

	@Override
	public void run(String... args) {
		print(this.firstAppProperties);
		print(this.secondAppProperties);
	}

}

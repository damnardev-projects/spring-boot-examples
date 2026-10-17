package fr.damnardev.spring.example.configuration_properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationPropertiesRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ConfigurationPropertiesRunner.class);

	private final AppProperties properties;

	public ConfigurationPropertiesRunner(AppProperties properties) {
		this.properties = properties;
	}

	@Override
	public void run(String... args) {
		logger.info("Application Name: {}", this.properties.name());
		logger.info("Application Version: {}", this.properties.version());
		logger.info("Application Stage: {}", this.properties.stage());
		logger.info("Application Timeout: {}", this.properties.timeout());
		logger.info("Application Retry Max Retries: {}", this.properties.retry()
		                                                                .maxRetries());
		logger.info("Application Retry Delay: {}", this.properties.retry()
		                                                          .delay());
		logger.info("Application Debug: {}", this.properties.debug());
		logger.info("Application Tags: {}", this.properties.tags());
		logger.info("Application Display Name (derived): {}", this.properties.displayName());
		logger.info("Application Greeting (relaxed binding): {}", this.properties.greeting());
	}

}

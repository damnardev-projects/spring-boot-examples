package fr.damnardev.spring.example.value_injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ValueInjectionRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ValueInjectionRunner.class);

	private final AppSettings settings;

	public ValueInjectionRunner(AppSettings settings) {
		this.settings = settings;
	}

	@Override
	public void run(String... args) {
		logger.info("Application Name: {}", this.settings.appName());
		logger.info("Application Version: {}", this.settings.appVersion());
		logger.info("Application Stage: {}", this.settings.appStage());
		logger.info("Application Timeout: {}", this.settings.appTimeout());
		logger.info("Application Max Retries: {}", this.settings.appMaxRetries());
		logger.info("Application Debug: {}", this.settings.appDebug());
		logger.info("Application Tags: {}", this.settings.appTags());
		logger.info("Application Display Name (SpEL): {}", this.settings.appDisplayName());
		logger.info("Application Greeting (environment variable): {}", this.settings.appGreeting());
	}

}

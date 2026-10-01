package fr.damnardev.spring.example.valueannotation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PropertyValueRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(PropertyValueRunner.class);

	/*
	 * String value (required property).
	 */
	@Value("${app.name}")
	private String appName;

	/*
	 * String value with fallback to 1.0.0. Not overridden by application.yml.
	 */
	@Value("${app.version:1.0.0}")
	private String appVersion;

	/*
	 * String value with fallback to 'development'. Overridden by application.yml if defined.
	 */
	@Value("${app.environment:development}")
	private String environment;

	/*
	 * Integer value (required property).
	 */
	@Value("${app.port}")
	private int port;

	/*
	 * Boolean value (required property).
	 */
	@Value("${app.debug}")
	private boolean debug;

	/*
	 * List of String values (required property).
	 * To have more information about Spring Expression Language (SpEL): https://docs.spring.io/spring-framework/reference/core/expressions/beandef.html
	 */
	@Value("#{'${app.tags}'.split(',')}")
	private List<String> tags;

	/*
	 * JVM home directory resolved from JAVA_HOME environment variable.
	 */
	@Value("${JAVA_HOME:not-set}")
	private String javaHome;

	@Override
	public void run(String... args) {
		logger.info("Application Name: {}", this.appName);
		logger.info("Application Version: {}", this.appVersion);
		logger.info("Environment: {}", this.environment);
		logger.info("Server Port: {}", this.port);
		logger.info("Debug Mode: {}", this.debug);
		logger.info("Tags: {}", this.tags);
		logger.info("Java Home: {}", this.javaHome);
	}

}

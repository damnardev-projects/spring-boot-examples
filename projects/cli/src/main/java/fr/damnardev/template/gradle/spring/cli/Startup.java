package fr.damnardev.template.gradle.spring.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

import fr.damnardev.template.gradle.spring.common.Calculator;

@SpringBootApplication(nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
public class Startup implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("10 + 10 = {}", new Calculator().add(10, 10));
	}

}

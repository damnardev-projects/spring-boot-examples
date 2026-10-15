package fr.damnardev.spring.example.application_runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.FullyQualifiedConfigurationBeanNameGenerator;

@SpringBootApplication(
		scanBasePackages = "fr.damnardev.spring.example.application_runner",
		nameGenerator = FullyQualifiedConfigurationBeanNameGenerator.class
)
public class Startup {

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}

}

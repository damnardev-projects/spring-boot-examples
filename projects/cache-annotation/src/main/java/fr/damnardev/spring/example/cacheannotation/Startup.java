package fr.damnardev.spring.example.cacheannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.FullyQualifiedConfigurationBeanNameGenerator;

@EnableCaching
@SpringBootApplication(
		scanBasePackages = "fr.damnardev.spring.example.cacheannotation",
		nameGenerator = FullyQualifiedConfigurationBeanNameGenerator.class
)
public class Startup {

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}

}

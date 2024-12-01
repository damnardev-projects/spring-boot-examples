package fr.damnardev.example.springboot.rest.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@ComponentScan(basePackages = "fr.damnardev.example.springboot.rest", nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
@SpringBootApplication
public class RestControllerOpeAPIRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestControllerOpeAPIRunner.class, args);
	}

}

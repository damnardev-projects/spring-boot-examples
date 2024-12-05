package fr.damnardev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@ComponentScan(basePackages = "fr.damnardev", nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
@SpringBootApplication
public class RestControllerRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestControllerRunner.class, args);
	}

}

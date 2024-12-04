package fr.damnardev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@ComponentScan(basePackages = "fr.damnardev", nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
@SpringBootApplication
public class StompServerRunner {

	public static void main(String[] args) {
		SpringApplication.run(StompServerRunner.class, args);
	}

}

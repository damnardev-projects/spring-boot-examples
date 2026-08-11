package fr.damnardev.spring.example.configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class CustomConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "first-app")
	public AppProperties firstAppProperties() {
		return new AppProperties();
	}

	@Bean
	@ConfigurationProperties(prefix = "second-app")
	public AppProperties secondAppProperties() {
		return new AppProperties();
	}

}

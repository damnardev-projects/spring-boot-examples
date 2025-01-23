package fr.damnardev.configuration;

import fr.damnardev.properties.CustomProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class PropertiesConfiguration {

	@Bean(name = "customProperties")
	@ConfigurationProperties(prefix = "custom")
	public CustomProperties customProperties() {
		return new CustomProperties();
	}

}

package fr.damnardev.spring.example.configuration_properties;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.boot.convert.DurationUnit;

@ConfigurationProperties(prefix = "app")
public record AppProperties(
		String name,
		@DefaultValue("1.0.0") String version,
		@DefaultValue("development") String stage,
		@DefaultValue("30s") @DurationUnit(ChronoUnit.SECONDS) Duration timeout,
		@DefaultValue Retry retry,
		boolean debug,
		List<String> tags,
		@DefaultValue("not-set") String greeting) {

	public String displayName() {
		return this.name.toUpperCase();
	}

	public record Retry(int maxRetries, @DefaultValue("500ms") Duration delay) {
	}

}

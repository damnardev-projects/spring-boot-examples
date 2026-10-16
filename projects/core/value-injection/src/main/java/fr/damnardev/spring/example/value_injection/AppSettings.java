package fr.damnardev.spring.example.value_injection;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public record AppSettings(
		@Value("${app.name}") String appName,
		@Value("${app.version:1.0.0}") String appVersion,
		@Value("${app.stage:development}") String appStage,
		@Value("${app.timeout:30}") int appTimeout,
		@Value("${app.max-retries}") int appMaxRetries,
		@Value("${app.debug}") boolean appDebug,
		@Value("${app.tags}") List<String> appTags,
		@Value("#{'${app.name}'.toUpperCase()}") String appDisplayName,
		@Value("${APP_GREETING:not-set}") String appGreeting) {

}

package fr.damnardev.handler;

import fr.damnardev.properties.CustomProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomHandler implements ApplicationRunner {

	private final CustomProperties customProperties;

	@Override
	public void run(ApplicationArguments args) {
		log.info("Custom properties: {}", this.customProperties);
	}

}

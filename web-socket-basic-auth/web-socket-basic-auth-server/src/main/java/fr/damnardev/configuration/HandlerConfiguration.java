package fr.damnardev.configuration;

import fr.damnardev.handler.DefaultWebSocketHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerConfiguration {

	@Bean
	public DefaultWebSocketHandler webSocketHandler() {
		return new DefaultWebSocketHandler();
	}

}

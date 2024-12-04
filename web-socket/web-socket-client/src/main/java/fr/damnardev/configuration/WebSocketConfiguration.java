package fr.damnardev.configuration;

import fr.damnardev.handler.DefaultWebSocketHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Configuration
public class WebSocketConfiguration {

	@Bean
	public StandardWebSocketClient webSocketClient() {
		return new StandardWebSocketClient();
	}

	@Bean
	public DefaultWebSocketHandler webSocketHandler() {
		return new DefaultWebSocketHandler();
	}

	@Bean
	public WebSocketConnectionManager webSocketConnectionManager(StandardWebSocketClient webSocketClient, WebSocketHandler webSocketHandler) {
		var connectionManager = new WebSocketConnectionManager(webSocketClient, webSocketHandler, "ws://localhost:8080/ws");
		connectionManager.start();
		return connectionManager;
	}

}

package fr.damnardev.configuration;

import java.util.Base64;
import java.util.concurrent.ExecutionException;

import fr.damnardev.handler.DefaultWebSocketHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Configuration
public class StompConfiguration {

	@Bean
	public WebSocketStompClient webSocketStompClient() {
		var stompClient = new WebSocketStompClient(new StandardWebSocketClient());
		stompClient.setMessageConverter(new StringMessageConverter());
		return stompClient;
	}

	@Bean
	public DefaultWebSocketHandler webSocketHandler() {
		return new DefaultWebSocketHandler();
	}

	@Bean
	public StompSession stompSession(WebSocketStompClient stompClient, DefaultWebSocketHandler sessionHandler) throws ExecutionException, InterruptedException {
		var headers = new WebSocketHttpHeaders();
		var basicAuthValue = "Basic " + Base64.getEncoder().encodeToString("user:password".getBytes());
		headers.add("Authorization", basicAuthValue);
		var session = stompClient.connectAsync("ws://localhost:8080/ws", headers, sessionHandler).get();
		session.subscribe("/topic/response", sessionHandler);
		return session;
	}

}

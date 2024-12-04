package fr.damnardev.handler;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Slf4j
public class DefaultWebSocketHandler implements WebSocketHandler {

	private WebSocketSession session;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("New WebSocket connection established with session id: {}", session.getId());
		this.session = session;
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		log.info("Received message: {}", message.getPayload());
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.info("Error on WebSocket connection with session id: {}", session.getId(), exception);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		log.info("WebSocket connection closed with session id: {} and close status: {}", session.getId(), closeStatus);
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	public void send(String value) throws IOException {
		this.session.sendMessage(new TextMessage(value));
	}

}

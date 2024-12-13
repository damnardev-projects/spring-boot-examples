package fr.damnardev.handler;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Slf4j
public class DefaultWebSocketHandler implements WebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("New WebSocket connection established with session id: {}", session.getId());
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		log.info("Received message: {}", message.getPayload());
		session.sendMessage(new TextMessage("response: " + message.getPayload()));
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.error("Error on WebSocket connection with session id: {}", session.getId(), exception);
		session.close(CloseStatus.SERVER_ERROR);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		log.info("WebSocket connection closed with session id: {} and close status: {}", session.getId(), closeStatus);
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

}

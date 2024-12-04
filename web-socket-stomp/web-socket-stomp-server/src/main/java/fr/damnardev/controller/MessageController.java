package fr.damnardev.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class MessageController {

	@MessageMapping("/request")
	@SendTo("/topic/response")
	public String handleMessage(String message) {
		log.info("Received message: {}", message);
		return "response: " + message;
	}

}

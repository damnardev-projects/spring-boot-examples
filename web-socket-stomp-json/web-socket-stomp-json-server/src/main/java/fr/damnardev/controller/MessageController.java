package fr.damnardev.controller;

import java.util.concurrent.atomic.AtomicLong;

import fr.damnardev.model.Message;
import fr.damnardev.model.MessageForm;
import lombok.extern.slf4j.Slf4j;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class MessageController {

	private final AtomicLong idGenerator = new AtomicLong(1);

	@MessageMapping("/request")
	@SendTo("/topic/response")
	public Message handleMessage(MessageForm message) {
		log.info("Received message: {}", message);
		return Message.builder().id(this.idGenerator.getAndIncrement())
				.content(message.content()).build();
	}

}

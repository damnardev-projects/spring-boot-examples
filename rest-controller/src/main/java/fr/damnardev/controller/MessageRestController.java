package fr.damnardev.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import fr.damnardev.model.Message;
import fr.damnardev.model.MessageForm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageRestController {

	private final Map<Long, Message> messages = new HashMap<>();

	private final AtomicLong idGenerator = new AtomicLong(1);

	public MessageRestController() {
		insertData("Hello, World!");
		insertData("Hello, Spring Boot!");
		insertData("Hello, REST Controller!");
	}

	private void insertData(String value) {
		var id = this.idGenerator.getAndIncrement();
		this.messages.put(id, Message.builder().id(id).content(value).build());
	}

	@GetMapping
	public ResponseEntity<Collection<Message>> findAll() {
		return ResponseEntity.ok(this.messages.values());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Message> findById(@PathVariable("id") long id) {
		if (this.messages.containsKey(id)) {
			return ResponseEntity.ok(this.messages.get(id));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Message> create(@RequestBody MessageForm form) {
		var message = Message.builder().id(this.idGenerator.getAndIncrement()).content(form.content()).build();
		this.messages.put(message.id(), message);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateById(@PathVariable("id") long id, @RequestBody MessageForm form) {
		if (this.messages.containsKey(id)) {
			var message = Message.builder().id(id).content(form.content()).build();
			this.messages.replace(id, message);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
		if (this.messages.containsKey(id)) {
			this.messages.remove(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}

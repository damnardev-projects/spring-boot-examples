package fr.damnardev.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import fr.damnardev.model.Message;
import fr.damnardev.model.MessageForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

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
@Tag(name = "Message", description = "Message API")
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
	@Operation(summary = "Find all messages", description = "Return all messages")
	@ApiResponse(description = "Return all messages", responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Message.class))))
	public ResponseEntity<Collection<Message>> findAll() {
		return ResponseEntity.ok(this.messages.values());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Find a message by ID", description = "Return a message by ID")
	@ApiResponse(description = "Return a message by ID", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Message.class)))
	@ApiResponse(description = "Message not found", responseCode = "404", content = @Content)
	public ResponseEntity<Message> findById(@PathVariable("id") long id) {
		if (this.messages.containsKey(id)) {
			return ResponseEntity.ok(this.messages.get(id));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@Operation(summary = "Create a message", description = "Create a message", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageForm.class))))
	@ApiResponse(description = "Create a message", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Message.class)))
	public ResponseEntity<Message> create(@RequestBody MessageForm form) {
		var message = Message.builder().id(this.idGenerator.getAndIncrement()).content(form.content()).build();
		this.messages.put(message.id(), message);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update a message by ID", description = "Update a message by ID", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = MessageForm.class))))
	@ApiResponse(description = "Update a message by ID", responseCode = "200")
	@ApiResponse(description = "Message not found", responseCode = "404")
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
	@Operation(summary = "Delete a message by ID", description = "Delete a message by ID")
	@ApiResponse(description = "Delete a message by ID", responseCode = "200")
	@ApiResponse(description = "Message not found", responseCode = "404")
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

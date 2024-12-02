package fr.damnardev.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import fr.damnardev.model.User;
import fr.damnardev.model.UserForm;
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
@RequestMapping("users")
@Tag(name = "User", description = "User API")
public class UserRestController {

	private final Map<Long, User> users = new HashMap<>();

	private final AtomicLong idGenerator = new AtomicLong(1);

	public UserRestController() {
		insertData("Foo");
		insertData("Bar");
		insertData("Fizz");
	}

	private void insertData(String value) {
		var id = this.idGenerator.getAndIncrement();
		this.users.put(id, User.builder().id(id).name(value).build());
	}

	@GetMapping
	@Operation(summary = "Find all users", description = "Return all users")
	@ApiResponse(description = "Return all users", responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class))))
	public ResponseEntity<Collection<User>> findAll() {
		return ResponseEntity.ok(this.users.values());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Find a user by ID", description = "Return a user by ID")
	@ApiResponse(description = "Return a user by ID", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
	@ApiResponse(description = "user not found", responseCode = "404", content = @Content)
	public ResponseEntity<User> findById(@PathVariable("id") long id) {
		if (this.users.containsKey(id)) {
			return ResponseEntity.ok(this.users.get(id));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@Operation(summary = "Create a user", description = "Create a user", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserForm.class))))
	@ApiResponse(description = "Create a user", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
	public ResponseEntity<User> create(@RequestBody UserForm form) {
		var user = User.builder().id(this.idGenerator.getAndIncrement()).name(form.name()).build();
		this.users.put(user.id(), user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update a user by ID", description = "Update a user by ID", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserForm.class))))
	@ApiResponse(description = "Update a user by ID", responseCode = "200")
	@ApiResponse(description = "user not found", responseCode = "404")
	public ResponseEntity<Void> updateById(@PathVariable("id") long id, @RequestBody UserForm form) {
		if (this.users.containsKey(id)) {
			var user = User.builder().id(id).name(form.name()).build();
			this.users.replace(id, user);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a user by ID", description = "Delete a user by ID")
	@ApiResponse(description = "Delete a user by ID", responseCode = "200")
	@ApiResponse(description = "user not found", responseCode = "404")
	public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
		if (this.users.containsKey(id)) {
			this.users.remove(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}

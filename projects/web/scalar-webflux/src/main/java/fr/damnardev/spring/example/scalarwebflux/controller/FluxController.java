package fr.damnardev.spring.example.scalarwebflux.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jspecify.annotations.NonNull;
import reactor.core.publisher.Flux;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flux")
@Tag(name = "Streams", description = "Reactive stream demonstrations")
public class FluxController {

	@GetMapping(value = "/time", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@Operation(summary = "Emit the current time", description = "Emits an SSE event immediately and then every second for 10 seconds.")
	public Flux<ServerSentEvent<String>> currentTime() {
		return Flux.interval(Duration.ZERO, Duration.ofSeconds(1))
				   .map(this::getTime)
				   .take(Duration.ofSeconds(10));
	}

	private @NonNull ServerSentEvent<String> getTime(Long ignored) {
		String currentTime = LocalDateTime.now(ZoneId.systemDefault())
										  .toString();
		return ServerSentEvent.<String>builder()
							  .event("time")
							  .data(currentTime)
							  .build();
	}

}

package fr.damnardev.spring.example.swaggerwebflux.controller;

import java.time.Duration;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
				   .map(ignored -> ServerSentEvent.<String>builder()
						   .event("time")
						   .data(LocalDateTime.now()
										.toString())
						   .build())
				   .take(Duration.ofSeconds(10));
	}

}
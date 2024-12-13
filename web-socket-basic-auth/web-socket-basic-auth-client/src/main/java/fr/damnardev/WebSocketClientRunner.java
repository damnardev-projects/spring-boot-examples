package fr.damnardev;

import java.util.Scanner;

import fr.damnardev.handler.DefaultWebSocketHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.web.socket.client.WebSocketConnectionManager;

@AllArgsConstructor
@ComponentScan(basePackages = "fr.damnardev", nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
@SpringBootApplication
@Slf4j
public class WebSocketClientRunner implements CommandLineRunner {

	private final WebSocketConnectionManager connectionManager;

	private final DefaultWebSocketHandler webSocketHandler;

	public static void main(String[] args) {
		SpringApplication.run(WebSocketClientRunner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.connectionManager.start();
		var running = true;
		var scanner = new Scanner(System.in);
		while (running) {
			log.info("Enter a message to send to the server or 'exit' to stop the client:");
			var value = scanner.nextLine();
			if ("exit".equalsIgnoreCase(value)) {
				running = false;
			}
			else {
				this.webSocketHandler.send(value);
				Thread.sleep(2000);
			}
		}
		this.connectionManager.stop();
	}

}

package fr.damnardev.spring.example.commandlinerunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldRunner.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("Hello World");
		if (args != null && args.length > 0) {
			logger.info("Args: {}", String.join(", ", args));
		}
		else {
			logger.info("No arguments provided");
		}
	}

}

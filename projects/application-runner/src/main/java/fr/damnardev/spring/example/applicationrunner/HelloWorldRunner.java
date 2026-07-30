package fr.damnardev.spring.example.applicationrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldRunner.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Hello World");

		// Retrieve all non-option arguments.
		// An argument is considered a non-option argument if it does not start with double dash (--).
		// "foo" or "-d" are non-option arguments, while "--debug" is an option argument.
		for (String arg : args.getNonOptionArgs()) {
			logger.info("Non Option Args: {}", arg);
		}

		// Retrieve all option arguments.
		// An argument is considered an option argument if it starts with double dash (--).
		for (String option : args.getOptionNames()) {
			logger.info("Option: {} = {}", option, String.join(", ", args.getOptionValues(option)));
		}
	}

}

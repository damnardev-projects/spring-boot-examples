package fr.damnardev.spring.example.jpacollection;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import fr.damnardev.spring.example.jpacollection.service.UserService;

@Component
public class UserCollectionRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(UserCollectionRunner.class);

	private final UserService userService;

	public UserCollectionRunner(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void run(ApplicationArguments args) {
		Long userId = this.userService.createUser(
				"Ada", "Lovelace", Set.of("ada@example.com", "ada.work@example.com"));
		this.logger("Initial", userId);

		String addedEmail = "ada.personal@example.com";
		this.userService.addEmail(userId, addedEmail);
		this.logger("After adding", userId);

		String removedEmail = "ada.work@example.com";
		this.userService.removeEmail(userId, removedEmail);
		this.logger("After removing", userId);
	}

	private void logger(String action, Long userId) {
		Set<String> emails = this.userService.findEmailsByUserId(userId);
		logger.info("{} email addresses for user {}: {}", action, userId, emails);
	}

}

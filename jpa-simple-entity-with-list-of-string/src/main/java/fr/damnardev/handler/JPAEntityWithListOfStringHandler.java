package fr.damnardev.handler;

import java.util.ArrayList;

import fr.damnardev.entity.DbUser;
import fr.damnardev.repository.DbUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class JPAEntityWithListOfStringHandler implements ApplicationRunner {

	private final DbUserRepository dbUserRepository;

	@Override
	@Transactional
	public void run(ApplicationArguments args) {
		var emails = new ArrayList<String>();
		var dbUser = DbUser.builder().name("Foo").emails(emails).build();
		log.info("Saving user {}", dbUser);
		var saved = this.dbUserRepository.save(dbUser);
		log.info("User saved {}", saved);
		var loaded = this.dbUserRepository.findById(saved.getId());
		log.info("User loaded {}", loaded);
		var updated = loaded.map((user) -> {
			user.getEmails().add("foo@bar.com");
			return this.dbUserRepository.save(user);
		});
		log.info("User updated {}", updated);
		var all = this.dbUserRepository.findAll();
		log.info("All users {}", all);
		this.dbUserRepository.deleteById(1L);
	}

}

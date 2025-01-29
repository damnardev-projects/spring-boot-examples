package fr.damnardev.handler;

import fr.damnardev.entity.DbAddress;
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
public class JPAEntityWithOneToOneHandler implements ApplicationRunner {

	private final DbUserRepository dbUserRepository;

	@Override
	@Transactional
	public void run(ApplicationArguments args) {
		var dbAddress = DbAddress.builder().city("Paris").street("my street").build();
		var dbUser = DbUser.builder().name("Foo").address(dbAddress).build();
		dbAddress.setUser(dbUser);
		log.info("Saving user {}", dbUser);
		var saved = this.dbUserRepository.save(dbUser);
		log.info("User saved {}", saved);
		var loaded = this.dbUserRepository.findById(saved.getId());
		log.info("User loaded {}", loaded);
		var updated = loaded.map((user) -> {
			user.setName("Bar");
			dbAddress.setCity("Lyon");
			return this.dbUserRepository.save(user);
		});
		log.info("User updated {}", updated);
		var all = this.dbUserRepository.findAll();
		log.info("All users {}", all);
		this.dbUserRepository.deleteById(1L);
	}

}

package fr.damnardev.spring.example.jpacollection.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.damnardev.spring.example.jpacollection.model.User;
import fr.damnardev.spring.example.jpacollection.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public Long createUser(String firstName, String lastName, Set<String> emails) {
		User user = this.userRepository.save(new User(firstName, lastName, emails));
		return user.getId();
	}

	@Transactional
	public void addEmail(Long userId, String email) {
		User user = this.findUser(userId);
		user.getEmails()
			.add(email);
	}

	@Transactional
	public void removeEmail(Long userId, String email) {
		User user = this.findUser(userId);
		user.getEmails()
			.remove(email);
	}

	@Transactional(readOnly = true)
	public Set<String> findEmailsByUserId(Long userId) {
		return Set.copyOf(this.findUser(userId)
							  .getEmails());
	}

	private User findUser(Long userId) {
		return this.userRepository.findById(userId)
								  .orElseThrow(() -> new IllegalStateException("User with id " + userId + " was not found"));
	}

}

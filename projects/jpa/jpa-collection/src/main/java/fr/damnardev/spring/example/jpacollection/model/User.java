package fr.damnardev.spring.example.jpacollection.model;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ElementCollection
	@CollectionTable(name = "t_user_email", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "email", nullable = false)
	private Set<String> emails = new LinkedHashSet<>();

	public User() {
	}

	public User(String firstName, String lastName, Set<String> emails) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emails.addAll(emails);
	}

	public Long getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public Set<String> getEmails() {
		return this.emails;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return this.id != null && Objects.equals(this.id, user.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + this.id +
				", firstName='" + this.firstName + '\'' +
				", lastName='" + this.lastName + '\'' +
				", emails=" + this.emails +
				'}';
	}

}
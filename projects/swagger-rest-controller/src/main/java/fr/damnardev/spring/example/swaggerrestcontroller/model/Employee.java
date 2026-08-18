package fr.damnardev.spring.example.swaggerrestcontroller.model;

import java.time.LocalDate;
import java.util.UUID;

public class Employee {

	private UUID id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;

	public Employee() {
	}

	public Employee(String firstName, String lastName, LocalDate birthday) {
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return this.birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

}

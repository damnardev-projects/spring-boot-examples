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
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

}

package fr.damnardev.spring.example.jpaonetoone.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birthday", columnDefinition = "DATE")
	private LocalDate birthday;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_details_id", unique = true)
	private EmployeeDetails details;

	public Employee() {
	}

	public Employee(String firstName, String lastName, LocalDate birthday, EmployeeDetails details) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.details = details;
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

	public LocalDate getBirthday() {
		return this.birthday;
	}

	public EmployeeDetails getDetails() {
		return this.details;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return this.id != null && Objects.equals(this.id, employee.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + this.id +
				", firstName='" + this.firstName + '\'' +
				", lastName='" + this.lastName + '\'' +
				", birthday=" + this.birthday +
				", details=" + this.details +
				'}';
	}

}

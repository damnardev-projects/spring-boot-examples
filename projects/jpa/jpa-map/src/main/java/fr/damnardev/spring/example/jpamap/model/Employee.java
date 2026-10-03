package fr.damnardev.spring.example.jpamap.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
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

	@ElementCollection
	@CollectionTable(name = "t_employee_contact_detail", joinColumns = @JoinColumn(name = "employee_id"))
	@MapKeyColumn(name = "contact_type", nullable = false)
	@MapKeyEnumerated(EnumType.STRING)
	@Column(name = "contact_value", nullable = false)
	private Map<ContactType, String> contactMethods = new LinkedHashMap<>();

	public Employee() {
	}

	public Employee(String firstName, String lastName, Map<ContactType, String> contactMethods) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactMethods.putAll(contactMethods);
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

	public Map<ContactType, String> getContactMethods() {
		return this.contactMethods;
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
				", contactMethods=" + this.contactMethods +
				'}';
	}

}

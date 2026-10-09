package fr.damnardev.spring.example.jpaonetoone.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_employee_details")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "office_location")
	private String officeLocation;

	public EmployeeDetails() {
	}

	public EmployeeDetails(String jobTitle, String officeLocation) {
		this.jobTitle = jobTitle;
		this.officeLocation = officeLocation;
	}

	public Long getId() {
		return this.id;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EmployeeDetails that = (EmployeeDetails) o;
		return this.id != null && Objects.equals(this.id, that.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public String toString() {
		return "EmployeeDetails{" +
				"id=" + this.id +
				", jobTitle='" + this.jobTitle + '\'' +
				", officeLocation='" + this.officeLocation + '\'' +
				'}';
	}

}

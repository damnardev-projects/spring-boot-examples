package fr.damnardev.spring.example.jpamap.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.damnardev.spring.example.jpamap.model.Employee;
import fr.damnardev.spring.example.jpamap.model.ContactType;
import fr.damnardev.spring.example.jpamap.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Transactional
	public Long createEmployee(String firstName, String lastName, Map<ContactType, String> contactMethods) {
		Employee employee = this.employeeRepository.save(new Employee(firstName, lastName, contactMethods));
		return employee.getId();
	}

	@Transactional
	public void updateContactDetail(Long employeeId, ContactType type, String value) {
		Employee employee = this.findEmployee(employeeId);
		employee.getContactMethods()
				.put(type, value);
	}

	@Transactional(readOnly = true)
	public Map<ContactType, String> findContactDetailsById(Long employeeId) {
		return Map.copyOf(this.findEmployee(employeeId)
								.getContactMethods());
	}

	private Employee findEmployee(Long employeeId) {
		return this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new IllegalStateException("Employee with id " + employeeId + " was not found"));
	}

}

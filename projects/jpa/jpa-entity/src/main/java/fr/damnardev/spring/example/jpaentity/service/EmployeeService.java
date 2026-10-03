package fr.damnardev.spring.example.jpaentity.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.damnardev.spring.example.jpaentity.model.Employee;
import fr.damnardev.spring.example.jpaentity.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Transactional
	public List<Employee> createInitialEmployees() {
		return this.employeeRepository.saveAll(List.of(
				new Employee("Ada", "Lovelace", LocalDate.of(1815, 12, 10)),
				new Employee("Alan", "Turing", LocalDate.of(1912, 6, 23)),
				new Employee("Grace", "Hopper", LocalDate.of(1906, 12, 9)),
				new Employee("Katherine", "Johnson", LocalDate.of(1918, 8, 26)),
				new Employee("Dennis", "Ritchie", LocalDate.of(1941, 9, 9)),
				new Employee("Margaret", "Hamilton", LocalDate.of(1936, 8, 17)),
				new Employee("Edsger", "Dijkstra", LocalDate.of(1930, 5, 11)),
				new Employee("Barbara", "Liskov", LocalDate.of(1939, 11, 7)),
				new Employee("James", "Gosling", LocalDate.of(1955, 5, 19)),
				new Employee("Guido", "van Rossum", LocalDate.of(1956, 1, 31))
		));
	}

	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return this.employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	@Transactional
	public Employee createEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Transactional(readOnly = true)
	public Employee getById(Long id) {
		return this.employeeRepository.findById(id)
									  .orElseThrow(() -> new IllegalStateException("Inserted employee was not found"));
	}

	@Transactional
	public Employee updateEmployee(Long id, String firstName, String lastName, LocalDate birthday) {
		Employee employee = this.employeeRepository.findById(id)
												   .orElseThrow(() -> new IllegalStateException("Employee to update was not found"));
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setBirthday(birthday);
		return this.employeeRepository.save(employee);
	}

	@Transactional
	public void deleteEmployee(Long id) {
		this.employeeRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public boolean existsById(Long id) {
		return this.employeeRepository.existsById(id);
	}

}

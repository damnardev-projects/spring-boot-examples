package fr.damnardev.spring.example.jpaexample;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import fr.damnardev.spring.example.jpaexample.model.Employee;
import fr.damnardev.spring.example.jpaexample.repository.EmployeeRepository;

@Component
public class EmployeeCrudRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeCrudRunner.class);

	private final EmployeeRepository employeeRepository;

	public EmployeeCrudRunner(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void run(ApplicationArguments args) {
		this.initData();
		this.getAll();

		Employee insertedEmployee = this.save();
		Employee fetchedEmployee = this.getById(insertedEmployee.getId());
		Employee updatedEmployee = this.update(fetchedEmployee);
		this.delete(updatedEmployee);
	}

	private void initData() {
		List<Employee> employees = this.employeeRepository.saveAll(List.of(
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
		logger.info("Created {} employees", employees.size());
	}

	private void getAll() {
		List<Employee> listedEmployees = this.employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		logger.info("Listing the {} employees", listedEmployees.size());
		listedEmployees.forEach(employee -> logger.info("{}", employee));
	}

	private Employee save() {
		Employee insertedEmployee = this.employeeRepository.save(
				new Employee("Donald", "Knuth", LocalDate.of(1938, 1, 10)));
		logger.info("Inserted employee: {}", insertedEmployee);
		return insertedEmployee;
	}

	private Employee getById(Long id) {
		Employee fetchedEmployee = this.employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Inserted employee was not found"));
		logger.info("Fetched employee: {}", fetchedEmployee);
		return fetchedEmployee;
	}

	private Employee update(Employee fetchedEmployee) {
		fetchedEmployee.setFirstName("Donald E.");
		fetchedEmployee.setLastName("Knuth");
		fetchedEmployee.setBirthday(LocalDate.of(1938, 1, 11));
		Employee updatedEmployee = this.employeeRepository.save(fetchedEmployee);
		logger.info("Updated employee: {}", updatedEmployee);
		return updatedEmployee;
	}

	private void delete(Employee employee) {
		this.employeeRepository.deleteById(employee.getId());
		logger.info("Deleted employee with id {}: {}", employee.getId(),
				!this.employeeRepository.existsById(employee.getId()));
	}

}
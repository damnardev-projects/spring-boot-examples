package fr.damnardev.spring.example.jpaentity;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import fr.damnardev.spring.example.jpaentity.model.Employee;
import fr.damnardev.spring.example.jpaentity.service.EmployeeService;

@Component
public class EmployeeCrudRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeCrudRunner.class);

	private final EmployeeService employeeService;

	public EmployeeCrudRunner(EmployeeService employeeService) {
		this.employeeService = employeeService;
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
		List<Employee> employees = this.employeeService.createInitialEmployees();
		logger.info("Created {} employees", employees.size());
	}

	private void getAll() {
		List<Employee> listedEmployees = this.employeeService.findAll();
		logger.info("Listing the {} employees", listedEmployees.size());
		listedEmployees.forEach(employee -> logger.info("{}", employee));
	}

	private Employee save() {
		Employee insertedEmployee = this.employeeService.createEmployee(
				new Employee("Donald", "Knuth", LocalDate.of(1938, 1, 10)));
		logger.info("Inserted employee: {}", insertedEmployee);
		return insertedEmployee;
	}

	private Employee getById(Long id) {
		Employee fetchedEmployee = this.employeeService.getById(id);
		logger.info("Fetched employee: {}", fetchedEmployee);
		return fetchedEmployee;
	}

	private Employee update(Employee fetchedEmployee) {
		Employee updatedEmployee = this.employeeService.updateEmployee(fetchedEmployee.getId(),
				"Donald E.", "Knuth", LocalDate.of(1938, 1, 11));
		logger.info("Updated employee: {}", updatedEmployee);
		return updatedEmployee;
	}

	private void delete(Employee employee) {
		this.employeeService.deleteEmployee(employee.getId());
		logger.info("Deleted employee with id {}: {}", employee.getId(),
				!this.employeeService.existsById(employee.getId()));
	}

}

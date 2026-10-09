package fr.damnardev.spring.example.jpaonetoone;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import fr.damnardev.spring.example.jpaonetoone.model.Employee;
import fr.damnardev.spring.example.jpaonetoone.model.EmployeeDetails;
import fr.damnardev.spring.example.jpaonetoone.service.EmployeeService;

@Component
public class EmployeeCrudRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeCrudRunner.class);

	private final EmployeeService employeeService;

	public EmployeeCrudRunner(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public void run(ApplicationArguments args) {
		Employee insertedEmployee = this.employeeService.createEmployee(
				new Employee("Ada", "Lovelace", LocalDate.of(1980, 12, 10),
						new EmployeeDetails("Mathematician", "London")));
		logger.info("Inserted employee and cascaded details: {}", insertedEmployee);

		Employee fetchedEmployee = this.employeeService.getById(insertedEmployee.getId());
		logger.info("Fetched employee with eagerly loaded details: {}", fetchedEmployee);

		Long detailsId = fetchedEmployee.getDetails()
										.getId();
		this.employeeService.updateEmployeeDetails(detailsId, "Senior Mathematician", "Cambridge");
		Employee employeeAfterDetailsUpdate = this.employeeService.getById(fetchedEmployee.getId());
		logger.info("Employee after updating only its details: {}", employeeAfterDetailsUpdate);

		this.employeeService.deleteEmployee(fetchedEmployee.getId());
		logger.info("Deleted employee; associated details still exist: {}",
				this.employeeService.employeeDetailsExist(detailsId));
	}

}

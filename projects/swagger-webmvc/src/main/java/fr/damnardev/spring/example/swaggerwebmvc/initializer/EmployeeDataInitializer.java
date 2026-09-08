package fr.damnardev.spring.example.swaggerwebmvc.initializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import fr.damnardev.spring.example.swaggerwebmvc.model.Employee;
import fr.damnardev.spring.example.swaggerwebmvc.repository.EmployeeRepository;

@Component
public class EmployeeDataInitializer implements ApplicationRunner {

	private static final String[] FIRST_NAMES = {
			"Osian", "Harri", "Arthur", "Emrys", "Noa",
			"Mali", "Alys", "Efa", "Eleri", "Gwenllian"
	};

	private static final String[] LAST_NAMES = {
			"Smith", "Jones", "Taylor", "Brown", "Williams",
			"Wilson", "Johnson", "Davies", "Patel", "Robinson"
	};

	private final EmployeeRepository employeeRepository;

	public EmployeeDataInitializer(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void run(ApplicationArguments args) {
		LocalDate today = LocalDate.now();
		LocalDate earliestBirthday = LocalDate.of(1940, 1, 1);
		List<Employee> employees = new ArrayList<>(FIRST_NAMES.length * LAST_NAMES.length);
		for (String firstName : FIRST_NAMES) {
			for (String lastName : LAST_NAMES) {
				long randomDay = ThreadLocalRandom.current()
												  .nextLong(earliestBirthday.toEpochDay(), today.plusDays(1)
				                                                                                .toEpochDay());
				employees.add(new Employee(firstName, lastName, LocalDate.ofEpochDay(randomDay)));
			}
		}
		this.employeeRepository.saveAll(employees);
	}

}

package fr.damnardev.spring.example.jpamap;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import fr.damnardev.spring.example.jpamap.model.ContactType;
import fr.damnardev.spring.example.jpamap.service.EmployeeService;

@Component
public class EmployeeMapRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeMapRunner.class);

	private final EmployeeService employeeService;

	public EmployeeMapRunner(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public void run(ApplicationArguments args) {
		Long employeeId = this.employeeService.createEmployee(
				"Ada", "Lovelace", Map.of(ContactType.EMAIL, "ada@example.com", ContactType.PHONE, "+44 1234 567890"));
		this.logContactDetails("Initial", employeeId);

		this.employeeService.updateContactDetail(employeeId, ContactType.PHONE, "+44 9876 543210");
		this.logContactDetails("After updating the phone number", employeeId);
	}

	private void logContactDetails(String action, Long employeeId) {
		Map<ContactType, String> contactMethods = this.employeeService.findContactDetailsById(employeeId);
		logger.info("{} contact methods for employee {}: {}", action, employeeId, contactMethods);
	}

}

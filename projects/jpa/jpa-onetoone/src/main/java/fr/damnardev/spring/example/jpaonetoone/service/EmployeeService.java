package fr.damnardev.spring.example.jpaonetoone.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.damnardev.spring.example.jpaonetoone.model.Employee;
import fr.damnardev.spring.example.jpaonetoone.model.EmployeeDetails;
import fr.damnardev.spring.example.jpaonetoone.repository.EmployeeDetailsRepository;
import fr.damnardev.spring.example.jpaonetoone.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	private final EmployeeDetailsRepository employeeDetailsRepository;

	public EmployeeService(EmployeeRepository employeeRepository,
			EmployeeDetailsRepository employeeDetailsRepository) {
		this.employeeRepository = employeeRepository;
		this.employeeDetailsRepository = employeeDetailsRepository;
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
	public EmployeeDetails updateEmployeeDetails(Long id, String jobTitle, String officeLocation) {
		EmployeeDetails details = this.employeeDetailsRepository.findById(id)
																.orElseThrow(() -> new IllegalStateException("Employee details to update were not found"));
		details.setJobTitle(jobTitle);
		details.setOfficeLocation(officeLocation);
		return this.employeeDetailsRepository.save(details);
	}

	@Transactional
	public void deleteEmployee(Long id) {
		this.employeeRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public boolean employeeDetailsExist(Long id) {
		return this.employeeDetailsRepository.existsById(id);
	}

}

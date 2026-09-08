package fr.damnardev.spring.example.swaggerwebmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.damnardev.spring.example.swaggerwebmvc.dto.EmployeeDto;
import fr.damnardev.spring.example.swaggerwebmvc.dto.EmployeeListDto;
import fr.damnardev.spring.example.swaggerwebmvc.model.Employee;
import fr.damnardev.spring.example.swaggerwebmvc.repository.EmployeeRepository;

@Service
public class EmployeeService {

	public static final int MAX_PAGE_SIZE = 100;

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Transactional(readOnly = true)
	public EmployeeListDto getAllEmployees(int page, int size) {
		Page<Employee> employeePage = this.employeeRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")));
		List<EmployeeDto> employees = employeePage.getContent()
												  .stream()
												  .map(this::toDto)
												  .toList();
		long totalElements = employeePage.getTotalElements();
		int totalPages = employeePage.getTotalPages();
		return new EmployeeListDto(employees, size, page, totalElements, totalPages);
	}

	@Transactional(readOnly = true)
	public Optional<EmployeeDto> getEmployeeById(Long id) {
		return this.employeeRepository.findById(id)
									  .map(this::toDto);
	}

	@Transactional
	public EmployeeDto createEmployee(EmployeeDto employee) {
		return toDto(this.employeeRepository.save(toEntity(employee)));
	}

	@Transactional
	public Optional<EmployeeDto> updateEmployee(Long id, EmployeeDto updatedEmployee) {
		return this.employeeRepository.findById(id)
									  .map(employee -> {
										  employee.setFirstName(updatedEmployee.firstName());
										  employee.setLastName(updatedEmployee.lastName());
										  employee.setBirthday(updatedEmployee.birthday());
										  return toDto(this.employeeRepository.save(employee));
									  });
	}

	@Transactional
	public boolean deleteEmployee(Long id) {
		return this.employeeRepository.findById(id)
									  .map(employee -> {
										  this.employeeRepository.delete(employee);
										  return true;
									  })
									  .orElse(false);
	}

	private EmployeeDto toDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getBirthday());
	}

	private Employee toEntity(EmployeeDto employee) {
		return new Employee(employee.firstName(), employee.lastName(), employee.birthday());
	}

}

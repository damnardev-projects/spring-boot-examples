package fr.damnardev.spring.example.scalarwebflux.service;

import reactor.core.publisher.Mono;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.damnardev.spring.example.scalarwebflux.dto.EmployeeDto;
import fr.damnardev.spring.example.scalarwebflux.dto.EmployeeListDto;
import fr.damnardev.spring.example.scalarwebflux.model.Employee;
import fr.damnardev.spring.example.scalarwebflux.repository.EmployeeRepository;

@Service
public class EmployeeService {

	public static final int MAX_PAGE_SIZE = 100;

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Mono<EmployeeListDto> getAllEmployees(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id"));
		Mono<java.util.List<EmployeeDto>> employeesMono = this.employeeRepository.findAllBy(pageRequest)
																				 .map(this::toDto)
																				 .collectList();
		return employeesMono.zipWith(this.employeeRepository.count())
							.map(tuple -> {
								long totalElements = tuple.getT2();
								int totalPages = totalElements == 0 ? 0 : (int) Math.ceil((double) totalElements / size);
								return new EmployeeListDto(tuple.getT1(), size, page, totalElements, totalPages);
							});
	}

	public Mono<EmployeeDto> getEmployeeById(Long id) {
		return this.employeeRepository.findById(id)
									  .map(this::toDto);
	}

	public Mono<EmployeeDto> createEmployee(EmployeeDto employee) {
		return this.employeeRepository.save(toEntity(employee))
									  .map(this::toDto);
	}

	public Mono<EmployeeDto> updateEmployee(Long id, EmployeeDto updatedEmployee) {
		return this.employeeRepository.findById(id)
									  .flatMap(employee -> {
										  employee.setFirstName(updatedEmployee.firstName());
										  employee.setLastName(updatedEmployee.lastName());
										  employee.setBirthday(updatedEmployee.birthday());
										  return this.employeeRepository.save(employee);
									  })
									  .map(this::toDto);
	}

	public Mono<Boolean> deleteEmployee(Long id) {
		return this.employeeRepository.findById(id)
									  .flatMap(employee -> this.employeeRepository.delete(employee)
																				  .thenReturn(Boolean.TRUE))
									  .defaultIfEmpty(Boolean.FALSE);
	}

	private EmployeeDto toDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getBirthday());
	}

	private Employee toEntity(EmployeeDto employee) {
		return new Employee(employee.firstName(), employee.lastName(), employee.birthday());
	}

}

package fr.damnardev.spring.example.scalarwebflux.repository;

import reactor.core.publisher.Flux;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import fr.damnardev.spring.example.scalarwebflux.model.Employee;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

	Flux<Employee> findAllBy(Pageable pageable);

}

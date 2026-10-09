package fr.damnardev.spring.example.jpaonetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.damnardev.spring.example.jpaonetoone.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

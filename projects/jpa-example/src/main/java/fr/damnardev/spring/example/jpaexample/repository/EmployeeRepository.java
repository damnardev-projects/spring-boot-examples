package fr.damnardev.spring.example.jpaexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.damnardev.spring.example.jpaexample.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
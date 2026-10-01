package fr.damnardev.spring.example.scalarwebmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.damnardev.spring.example.scalarwebmvc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

package fr.damnardev.spring.example.swaggerwebmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.damnardev.spring.example.swaggerwebmvc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

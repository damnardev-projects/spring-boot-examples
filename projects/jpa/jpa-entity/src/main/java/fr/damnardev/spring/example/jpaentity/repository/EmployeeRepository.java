package fr.damnardev.spring.example.jpaentity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.damnardev.spring.example.jpaentity.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

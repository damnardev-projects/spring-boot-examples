package fr.damnardev.spring.example.jpamap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.damnardev.spring.example.jpamap.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

package fr.damnardev.spring.example.jpaonetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.damnardev.spring.example.jpaonetoone.model.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

}

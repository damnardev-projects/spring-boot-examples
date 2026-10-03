package fr.damnardev.spring.example.jpacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.damnardev.spring.example.jpacollection.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
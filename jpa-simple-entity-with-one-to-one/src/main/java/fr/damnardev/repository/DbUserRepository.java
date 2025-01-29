package fr.damnardev.repository;

import fr.damnardev.entity.DbUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbUserRepository extends JpaRepository<DbUser, Long> {
}

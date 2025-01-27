package fr.damnardev.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "fr.damnardev.repository")
@EnableTransactionManagement
@EntityScan("fr.damnardev.entity")
public class DatabaseConfiguration {

}

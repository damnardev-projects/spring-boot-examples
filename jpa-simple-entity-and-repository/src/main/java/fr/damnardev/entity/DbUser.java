package fr.damnardev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name = "t_user")
public class DbUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_user")
	@SequenceGenerator(name = "s_user", sequenceName = "s_user", allocationSize = 1)
	private Long id;

	@Column(name = "username")
	private String name;

}

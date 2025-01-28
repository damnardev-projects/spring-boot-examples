package fr.damnardev.entity;

import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
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

	@ElementCollection
	@MapKeyColumn(name = "name")
	@Column(name = "result")
	@CollectionTable(name = "t_user_datas", joinColumns = @JoinColumn(name = "user_id"))
	private Map<String, String> datas;

}

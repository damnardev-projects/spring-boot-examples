package fr.damnardev.properties;

import java.util.List;

import fr.damnardev.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CustomProperties {

	private List<User> users;

}

package fr.damnardev.properties;

import java.util.Map;

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

	private Map<String, User> users;

}

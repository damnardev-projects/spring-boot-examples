package fr.damnardev.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

	@Bean
	public OpenAPI myOpenAPI() {
		var contact = new Contact();
		contact.setEmail("foo@bar.com");
		contact.setName("damnardev");
		contact.setUrl("https://github.com/damnardev/spring-boot-examples");

		var mitLicense = new License().name("").url("http://www.apache.org/licenses/");

		var info = new Info()
				.title("Spring Boot OpenAPI")
				.version("1.0.0")
				.contact(contact)
				.description("Spring Boot OpenAPI example")
				.license(mitLicense);

		var basicAuthScheme = new SecurityScheme()
				.type(SecurityScheme.Type.HTTP)
				.scheme("basic");

		var securityRequirement = new SecurityRequirement()
				.addList("basicAuth");

		var basicAuth = new Components().addSecuritySchemes("basicAuth", basicAuthScheme);

		return new OpenAPI().addSecurityItem(securityRequirement).components(basicAuth).info(info);
	}

}

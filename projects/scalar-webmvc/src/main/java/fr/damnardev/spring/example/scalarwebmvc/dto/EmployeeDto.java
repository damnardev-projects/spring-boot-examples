package fr.damnardev.spring.example.scalarwebmvc.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employee data transfer object")
public record EmployeeDto(
		@Schema(description = "Unique employee identifier", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
		Long id,
		@Schema(description = "Employee first name", example = "John")
		String firstName,
		@Schema(description = "Employee last name", example = "Doe")
		String lastName,
		@Schema(description = "Employee date of birth", example = "1990-01-15", format = "date")
		LocalDate birthday) {

}

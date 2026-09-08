package fr.damnardev.spring.example.scalarwebmvc.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

import fr.damnardev.spring.example.scalarwebmvc.dto.EmployeeDto;

@Schema(description = "Employee list data transfer object")
public record EmployeeListDto(
		@Schema(description = "List of employees")
		List<EmployeeDto> employees,
		@Schema(description = "Maximum number of employees per page", example = "10")
		int max,
		@Schema(description = "Current page number", example = "1")
		int currentPage,
		@Schema(description = "Total number of employees", example = "100")
		long totalElements,
		@Schema(description = "Total number of pages", example = "10")
		int totalPages) {
}

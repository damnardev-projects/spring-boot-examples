package fr.damnardev.template.gradle.spring.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("add should return the sum of two integers")
	void add_shouldReturnSum_whenValidInputsProvided() {
		// Given
		int firstNumber = 2;
		int secondNumber = 3;
		int expectedSum = 5;

		// When
		int result = calculator.add(firstNumber, secondNumber);

		// Then
		assertThat(result).isEqualTo(expectedSum);
	}

	@Test
	@DisplayName("subtract should return the difference of two integers")
	void subtract_shouldReturnDifference_whenValidInputsProvided() {
		// Given
		int firstNumber = 5;
		int secondNumber = 3;
		int expectedDifference = 2;

		// When
		int result = calculator.subtract(firstNumber, secondNumber);

		// Then
		assertThat(result).isEqualTo(expectedDifference);
	}

	@Test
	@DisplayName("multiply should return the product of two integers")
	void multiply_shouldReturnProduct_whenValidInputsProvided() {
		// Given
		int firstNumber = 2;
		int secondNumber = 3;
		int expectedProduct = 6;

		// When
		int result = calculator.multiply(firstNumber, secondNumber);

		// Then
		assertThat(result).isEqualTo(expectedProduct);
	}

	@Test
	@DisplayName("divide should return the quotient of two integers")
	void divide_shouldReturnQuotient_whenValidInputsProvided() {
		// Given
		int dividend = 6;
		int divisor = 3;
		int expectedQuotient = 2;

		// When
		int result = calculator.divide(dividend, divisor);

		// Then
		assertThat(result).isEqualTo(expectedQuotient);
	}

	@Test
	@DisplayName("divide should throw IllegalArgumentException when dividing by zero")
	void divide_shouldThrowIllegalArgumentException_whenDividingByZero() {
		// Given
		int dividend = 6;
		int divisor = 0;
		String expectedMessage = "Division by zero is not allowed";

		// When & Then
		assertThatThrownBy(() -> calculator.divide(dividend, divisor))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(expectedMessage);
	}

}

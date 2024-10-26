package com.incubyte.tdd.stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.incubyte.tdd.stringCalculator.serviceImpl.StringCalculatorImpl;

@SpringBootTest
class StringCalculatorApplicationTests {

	private final StringCalculatorImpl stringCalculatorImpl = new StringCalculatorImpl();

	@Test
	public void testEmptyStringNumbers() {
		Assertions.assertEquals(0, stringCalculatorImpl.add(""));
	}

	@Test
	public void testSingleNumberInput() {
		Assertions.assertEquals(1, stringCalculatorImpl.add("1"));
	}

	@Test
	public void testTwoNumberInput() {
		Assertions.assertEquals(3, stringCalculatorImpl.add("1,2"));
	}

	@Test
	public void testMultipleNumberInput() {
		Assertions.assertEquals(10, stringCalculatorImpl.add("1,2,3,4"));
	}

	@Test
	public void testNewlineDelimiterInNumberString() {
		Assertions.assertEquals(6, stringCalculatorImpl.add("1\n2,3"));
	}

	@Test
	public void testCustomDelimiterInNumberString() {
		Assertions.assertEquals(3, stringCalculatorImpl.add("//;\n1;2"));
	}

	@Test
	public void testNegativeNumberInNumberString() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			stringCalculatorImpl.add("-1,4,-3");
		});
		Assertions.assertEquals("negative numbers not allowed: [-1, -3]", exception.getMessage());
	}
	

	@Test
	public void testDifferentCustomDelimiterInNumberString() {
		Assertions.assertEquals(3, stringCalculatorImpl.add("//[**]\n1[**]2"));
	}
}

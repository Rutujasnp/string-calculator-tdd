package com.incubyte.tdd.stringCalculator.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.incubyte.tdd.stringCalculator.service.StringCalculator;

public class StringCalculatorImpl implements StringCalculator {

	@Override
	public int add(String numbers) {

		// if the string of numbers is empty
		if (numbers.isEmpty() || numbers.equals(" ")) {
			return 0;
		}

		// for numbers string has newline delimiter

		// for custom delimiters
		String delimiter = ",|\n";
		int delimiterIndex = numbers.indexOf("\n");
		if (numbers.startsWith("//")) {
			delimiter = numbers.substring(2, delimiterIndex);
			// Handle multiple character delimiters surrounded by []
			if (delimiter.startsWith("[") && delimiter.endsWith("]")) {
				delimiter = delimiter.substring(1, delimiter.length() - 1); // Remove the brackets
			}
			numbers = numbers.substring(delimiterIndex + 1);
		}

		int sum = 0;
		String numbersArray[] = numbers.split(delimiter);

		List<Integer> negativeNumbers = new ArrayList<>();// for negative numbers
		for (String numString : numbersArray) {
			int number = Integer.parseInt(numString.trim());
			if (number < 0) {
				negativeNumbers.add(number);// Collect negative numbers

			} else {
				sum += number;// Add non-negative numbers to the sum
			}

		}
		if (!negativeNumbers.isEmpty()) {
			throw new IllegalArgumentException("negative numbers not allowed: " + negativeNumbers);
		}
		return sum;
	}

}

package com.incubyte.tdd.stringCalculator.serviceImpl;

import com.incubyte.tdd.stringCalculator.service.StringCalculator;

public class StringCalculatorImpl implements StringCalculator {

	@Override
	public int add(String numbers) {

		// if the string of numbers is empty
		if (numbers.isEmpty() || numbers.equals(" ")) {
			return 0;
		}

		// for numbers string has newline delimiter

//		if (numbers.contains("\n")) {
//			numbers=numbers.replace("\n", ",");
//		}
		// for custom delimiters
		String delimiter = ",|\n";
		int delimiterIndex = numbers.indexOf("\n");
		if (numbers.startsWith("//")) {
			delimiter = numbers.substring(2, delimiterIndex);
			numbers= numbers.substring(delimiterIndex+1);
		}

		int sum = 0;
		String numbersArray[] = numbers.split(delimiter);
		for (String numString : numbersArray) {
			int number = Integer.parseInt(numString.trim());
			sum += number;

		}
		return sum;
	}

}

package com.incubyte.tdd.stringCalculator.serviceImpl;

import com.incubyte.tdd.stringCalculator.service.StringCalculator;

public class StringCalculatorImpl  implements  StringCalculator {

	@Override
	public int add(String numbers) {
		
		//if the string of numbers is empty
		if(numbers.isEmpty() || numbers.equals(" ")) {
			return 0;
		}
		//for single number input
		int number= Integer.parseInt(numbers);
		return number;
	}

}

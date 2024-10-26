package com.incubyte.tdd.stringCalculator.serviceImpl;

import com.incubyte.tdd.stringCalculator.service.StringCalculator;

public class StringCalculatorImpl  implements  StringCalculator {

	@Override
	public int add(String numbers) {
		
		//if the string of numbers is empty
		if(numbers.isEmpty() || numbers.equals(" ")) {
			return 0;
		}
		
		
		
		//for numbers string has two numbers
		String delimiter= ",";
		int sum=0;
		String numbersArray[]=numbers.split(delimiter);
		for (String numString: numbersArray){
			int number= Integer.parseInt(numString);
			sum+=number;
			
		}
		return sum;
	}

}

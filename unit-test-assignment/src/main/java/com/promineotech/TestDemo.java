package com.promineotech;

import java.util.Random;

public class TestDemo{
	
	//STEP 2
			
	public static int addPositive(int a, int b) {
		int result = 0;
		if (a > 0 && b > 0) {
			result = a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive");
		}
		return result;
		}
	
	
	//STEP 3
	
	public static String numEvenOdd(int n) {
		String even = "Even";
		String odd = "Odd";
		if (n % 2 == 0){
			return even;
			} else {
		return odd;
		}
	}
		
	
	//STEP 4
	
	int randomNumberSquared() {
		int random = getRandomInt();
		return random * random;
		}
	
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
		}

}

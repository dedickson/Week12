package com.promineotech;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;




class TestDemoJUnitTest{
	
	private static TestDemo testDemo;
	
	

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	//STEP 2

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected) {
//      int a = 1;
//		int b = 2; 
//		int expected = 3;
		boolean expectException = false;
		if(!expectException) {
			assertThat(TestDemo.addPositive(a, b)).isEqualTo(expected);
		} 
		else {
			assertThatThrownBy(() ->
		    TestDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);	
		}
	} 
	
	static Stream<Arguments> argumentsForAddPositive() {
		// formatter:off
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(0, 4, IllegalArgumentException.class, false),
				arguments(2, -1, 0, false),
				arguments(-8, -3, null, false),
				arguments(3, 1, 4, false)
				);
		// formatter:on
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly(){
			assertThat(TestDemo.addPositive(4,5)).isEqualTo(9);
			assertThat(TestDemo.addPositive(40,50)).isEqualTo(90);
	}
	
	//STEP 3
	
	@Test
	void assertOddEvenNumbersCorrect() {
		//Given: An integer value
		int given = 4;
		String expected = "Even";
		//When: To determine if integer is odd or even
		String actual = TestDemo.numEvenOdd(given);
		
		//Then: Return odd or even
		assertThat(actual).isEqualTo(expected);
		}
	
	
	//STEP 4
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
		
}
	
	
	
	



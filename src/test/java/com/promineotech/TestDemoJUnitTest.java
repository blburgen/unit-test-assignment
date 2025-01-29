package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	/* 
	 * Parameterized test method for addPositive method in TestDemo 
	 */
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	/* 
	 * Parameterized test method arguments 
	 */
	static Stream<Arguments> argumentsForAddPositive() {
		//@formatter:off
		return Stream.of(
			arguments(123,321,444,false),
			arguments(2,4,6,false),
			arguments(0,4,0,true),
			arguments(2,0,0,true),
			arguments(0,0,0, true),
			arguments(-1,6,0,true),
			arguments(2,-1,0,true)
		);
		//@formatter:on
	}
	
	/*
	 * Regular JUnitTest for addPositive method in TestDemo
	 */
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(1,5)).isEqualTo(6);
		assertThat(testDemo.addPositive(40,100)).isEqualTo(140);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
	}
	
	/*
	 * Regular JUnitTest for verifyMinimumHeightFourFeet methods in TestDemo
	 */
	@Test
	void assertThatRiderIsTallEnough() {
		assertThat(testDemo.verifyMinimumHeightFourFeet(47)).isEqualTo(false);
		assertThat(testDemo.verifyMinimumHeightFourFeet(48)).isEqualTo(true);
		assertThat(testDemo.verifyMinimumHeightFourFeet(50)).isEqualTo(true);
		assertThat(testDemo.verifyMinimumHeightFourFeet(0,48)).isEqualTo(true);
		assertThat(testDemo.verifyMinimumHeightFourFeet(5, 0)).isEqualTo(true);
		assertThatThrownBy(() -> testDemo.verifyMinimumHeightFourFeet(0)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.verifyMinimumHeightFourFeet(-1)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.verifyMinimumHeightFourFeet(0, 0)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.verifyMinimumHeightFourFeet(-7, 0)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.verifyMinimumHeightFourFeet(1, -12)).isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}

}

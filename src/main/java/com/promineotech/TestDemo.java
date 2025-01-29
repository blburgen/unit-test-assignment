package com.promineotech;

import java.util.Random;

public class TestDemo {

	/*
	 * This method adds two positive number together. If any of the numbers is not
	 * positive it prints out an exception.
	 */
	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

	/*
	 * Most carnival rides have a minimum height requirement of 48 inches. This
	 * method verifies the minimum height of a rider if only inches are provided.
	 */
	public boolean verifyMinimumHeightFourFeet(int inches) {
		if (inches > 0) {
			return inches >= 48;
		} else {
			throw new IllegalArgumentException("Parameter must be positive!");
		}
	}

	/*
	 * Most carnival rides have a minimum height requirement of 48 inches. This
	 * method verifies the minimum height of a rider if both feet and inches are
	 * provided.
	 */
	public boolean verifyMinimumHeightFourFeet(int feet, int inches) {
		int inchesTotal = feet * 12 + inches;
		if (inchesTotal > 0) {
			return inchesTotal >= 48;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

	/*
	 * returns a random integer multiplied by itself
	 */
	public int randomNumberSquared() {
		int randomInt = getRandomInt();
		return randomInt * randomInt;
	}
	
	/*
	 * returns a random integer
	 */
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}

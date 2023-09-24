package dev.bandeira.projecteulersolutions.problem30;

import java.util.stream.IntStream;

/*
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * 
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * 
 * As 1 = 1^4 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * 
 * COMPLETED ON 07/01/19 (lost implementation)
 * 
 * CURRENT SOLUTION IMPLEMENTED ON 24/09/2023
 */
public class Problem30 {

	private static final int DIGIT_POWER = 5;
	private static final int MAX_DIGIT_VALUE = (int) Math.pow(9, DIGIT_POWER);

	public static void main(String[] args) {
		int maxDigitAmount = 0;
		int maxPossibleValue;
		int maxPossibleSum;
		do {
			maxDigitAmount++;
			maxPossibleValue = (int) Math.pow(10, maxDigitAmount) - 1;
			maxPossibleSum = maxPossibleSum(maxDigitAmount);
		} while (maxPossibleSum >= maxPossibleValue);

		System.out.printf("maxPossibleSum: %d%nmaxDigitAmount: %d%n", maxPossibleSum, maxPossibleValue);

		final int sum = IntStream.range(2, maxPossibleSum).filter(number -> {
			final int digits = (int) Math.floor(Math.log10(number) + 1);
			int currentSum = 0;
			for (int n = 0, nthDigit = getNthDigit(number, n); n < digits; n++, nthDigit = getNthDigit(number, n)) {
				currentSum += Math.pow(nthDigit, DIGIT_POWER);
			}

			return number == currentSum;
		}).sum();

		System.out.print("Sum: " + sum);
	}

	private static int maxPossibleSum(final int numberOfDigits) {
		return MAX_DIGIT_VALUE * numberOfDigits;
	}

	private static byte getNthDigit(final int number, final int n) {
		return ((Double) (number / Math.pow(10, n) % 10)).byteValue();
	}

}
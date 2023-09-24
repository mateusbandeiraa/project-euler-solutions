package dev.bandeira.projecteulersolutions.problem16;

import java.math.BigInteger;

/*
 * https://projecteuler.net/problem=16
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 * COMPLETED ON 03/03/18
 */
public class Problem16 {
	public static void main(String[] args) {
		BigInteger power = new BigInteger("2").pow(1000);
		char[] chars = power.toString().toCharArray();

		int sum = 0;
		for (int i = 0; i < chars.length; i++) {
			sum += Character.getNumericValue(chars[i]);
		}

		System.out.println(sum);
	}
}

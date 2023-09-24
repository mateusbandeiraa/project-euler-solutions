package dev.bandeira.projecteulersolutions.problem15;

import java.math.BigDecimal;

/*
 * https://projecteuler.net/problem=15
 * Starting in the top left corner of a 2×2 grid, and only being able to move to
 * the right and down, there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 * 
 * COMPLETED ON 03/03/18
 */
public class Problem15 {
	public static void main(String[] args) {
		BigDecimal factorial40 = new BigDecimal(1);
		for (int i = 2; i <= 40; i++) {
			factorial40 = factorial40.multiply(new BigDecimal(i));
		}

		BigDecimal factorial20 = new BigDecimal(1);
		for (int i = 2; i <= 20; i++) {
			factorial20 = factorial20.multiply(new BigDecimal(i));
		}

		BigDecimal output = factorial40.divide(factorial20.multiply(factorial20));

		System.out.println(output.toString());
	}
}

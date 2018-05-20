package projectEuler;

import java.math.BigInteger;

/*
 * https://projecteuler.net/problem=20
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is
 * 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * COMPLETED ON 20/05/18
 * 
 * I know that using BigInteger looks kinda cheating. Most of Project Euler's
 * problems have a clever not-so-obvious way of doing things. I just couldn't
 * think of anything else. Maybe i'll come back to this problem later. TODO
 */
public class Euler_20 {
	public static void main(String[] args) {
		BigInteger factorial = new BigInteger("100");

		for (int i = 99; i > 1; i--) {
			factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
		}

		System.out.println(sumOfDigits(factorial));

	}

	public static long factorial(int n) {
		long factorial = 1;
		for (int i = 1; i <= n; i++) {
			System.out.print(factorial + " x " + i + " = ");
			factorial *= i;
			System.out.println(factorial + "(" + sumOfDigits(factorial) + ")");
		}
		return factorial;
	}

	public static int sumOfDigits(long n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	public static int sumOfDigits(BigInteger n) {
		int sum = 0;
		while (!n.equals(BigInteger.ZERO)) {
			sum += n.mod(BigInteger.TEN).intValue();
			n = n.divide(BigInteger.TEN);
		}
		return sum;
	}
}

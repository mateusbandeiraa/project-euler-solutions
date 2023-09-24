package dev.bandeira.projecteulersolutions.problem27;

import java.util.ArrayList;

/*
 * Euler discovered the remarkable quadratic formula: n²+n+41.
 * 
 * It turns out that the formula will produce 40 primes for the consecutive
 * integer values 0≤n≤3.
 * 
 * However, when n=40, 40²+40+41=40(40+1)+41 is divisible by 41, and certainly
 * when n=41,41²+41+41 is clearly divisible by 41.
 * 
 * The incredible formula n²−79n+1601 was discovered, which produces 80 primes
 * for the consecutive values 0≤n≤79. The product of the coefficients, −79 and
 * 1601, is −126479.
 * 
 * Considering quadratics of the form:
 * n² + an + b, where |a| < 1000 and |b| ≤ 1000
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11, |-4| = 4
 * 
 * Find the product of the coefficients, a and b, for the quadratic expression
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0.
 * 
 * COMPLETED ON 27/07/18
 */
public class Problem27 {
	private static boolean[] primes = new boolean[1_000_001];
	private static ArrayList<Integer> primesList = new ArrayList<>();
	private static boolean filled = false;

	public static boolean isPrime(int num) {
		return !primes[num];
	}

	public static void init() {
		if (!filled) { // Checks if this method was already called before.
			// This method of finding primes was borrowed from my solution to problem 10.
			for (int i = 2; i < primes.length; i++) {
				if (!primes[i]) {
					for (long j = (long) i * i; j < primes.length; j += i) {
						primes[(int) j] = true;
					}
				}
			}

			for (int i = 2; i <= 1000; i++) { // This ends at 1000 because b must be lower or equal to 1000.
				if (!primes[i]) {
					primesList.add(i);
				}
			}
			filled = true;
		}
	}

	public static void main(String[] args) {
		int recordPrimes = 0;
		int recordA = -999;
		int recordB = -1000;

		init();

		for (int a = -999; a < 1000; a++) {
			for (int b : primesList) { // When n = 0, it cancels the 2 first parts of the formula, remaining only b.
										// Therefore, b needs to be a prime number.
				int n = -1;
				int candidate = 0;
				do {
					n++;
					candidate = (int) (Math.pow(n, 2) + (n * a) + b);
				} while (candidate > 0 && isPrime(candidate));

				if (n > recordPrimes) {
					recordPrimes = n;
					recordA = a;
					recordB = b;
				}
			}
		}

		System.out.println("The formula is: " + "n² +" + recordA + "n +" + recordB);
		System.out.println("It generates " + recordPrimes + " consecutive prime numbers");
	}
}

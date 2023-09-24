package dev.bandeira.projecteulersolutions.problem23;

/*
 * https://projecteuler.net/problem=23
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 * 
 * COMPLETED ON 21/05/18
 */
public class Problem23 {
	public static final int LIMIT = 28123;

	public static void main(String[] args) {
		boolean[] isAbundant = new boolean[LIMIT];
		boolean[] canBeSum = new boolean[LIMIT];
		int sum = 0;

		for (int i = 0; i < isAbundant.length; i++) {
			isAbundant[i] = dn(i) > i ? true : false;
		}

		for (int i = 0; i < isAbundant.length; i++) {
			if (isAbundant[i]) {
				for (int j = i; i + j < isAbundant.length; j++) {
					if (isAbundant[j]) {
						canBeSum[i + j] = true;
					}
				}
			}
		}

		for (int i = 0; i < canBeSum.length; i++) {
			if (!canBeSum[i]) {
				sum += i;
			}
		}
		
		System.out.println(sum);
	}

	/*
	 * I borrowed this method from Euler_21. A proper explanation of this logic can
	 * be found there.
	 */
	public static int dn(int n) {
		int sum = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				sum += i;
				if (n / i != i && i != 1) {
					sum += n / i;
				}
			}
		}
		return sum;
	}

}

package projectEuler;

/*
 * https://projecteuler.net/problem=10
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * COMPLETED ON 17/02/18
 */
public class Euler_10 {
	public static void main(String[] args) {
		boolean[] numbers = new boolean[2_000_001];
		long sum = 0;

		for (int i = 2; i < numbers.length; i++) {
			if (!numbers[i]) {
				for (long j = (long) i * i; j < numbers.length; j += i) {
					numbers[(int) j] = true;
				}
			}
		}

		for (int i = 2; i < numbers.length; i++) {
			if (!numbers[i]) {
				sum += i;
			}
		}

		System.out.println(sum);
	}
}
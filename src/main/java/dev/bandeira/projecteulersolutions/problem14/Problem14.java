package dev.bandeira.projecteulersolutions.problem14;

/*
 * https://projecteuler.net/problem=14
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following
 * sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem),
 * it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * COMPLETED ON 03/03/18
 */
public class Problem14 {

	public static void main(String[] args) {
		long recordHolder = 0;
		long recordChain = 0;
		for (long i = 2; i < 1000000; i++) {
			long number = i;
			long curChain = 0;
			// System.out.println("number: " + i);
			while (number != 1) {
				number = nextlong(number);
				// System.out.println(" ᴸ" + number);
				curChain++;
			}
			if (curChain > recordChain) {
				recordHolder = i;
				recordChain = curChain;
				// System.out.println("NEW RECORD: " +
				// recordHolder + "→" + recordChain);
			}
		}

		System.out.println("RECORD: " + recordHolder + " → " + recordChain);
	}

	public static long nextlong(long number) {
		long output = -1;

		if (number != 1) {
			if (number % 2 == 0) {
				output = number / 2;
			} else {
				output = number * 3 + 1;
			}
		}

		return output;
	}
}

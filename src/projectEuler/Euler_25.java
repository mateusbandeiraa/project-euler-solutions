package projectEuler;

import java.math.BigInteger;

/*
 * The Fibonacci sequence is defined by the recurrence relation:
 * 
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 * 
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 * 
 * What is the index of the first term in the Fibonacci sequence to contain 1000
 * digits?
 * 
 * COMPLETED ON 16/07/18
 * 
 */
public class Euler_25 {
	public static final Double phi = 1.6180339887498948;

	public static void main(String[] args) {
		// METHOD 1
		System.out.println(Math.ceil((999 + (Math.log10(5) / 2))/Math.log10(phi)));
		
		// METHOD 2
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		BigInteger max = BigInteger.TEN.pow(999);
		
		int count = 2;
		while(b.compareTo(max) < 0) {
			BigInteger aux = a.add(b);
			a = b;
			b = aux;
			count++;
		}
		
		System.out.println(count);
	}
}

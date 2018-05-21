package projectEuler;

/*
 * https://projecteuler.net/problem=21
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and
 * each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * COMPLETED ON 20/05/18
 * 
 * METHOD 1 works, but gets a little hard on the processor when working with big
 * numbers (>100.000), as it calls the dn() function twice.
 * METHOD 2, on the other hand, calls dn() once for every value and stores it in
 * an array. This saves processing time, but uses more memory.
 */
public class Euler_21 {
	public static void main(String[] args) {
		System.out.println(method2(10_000));
	}

	public static int method1(int n) {
		int sum = 0;
		for (int a = 0; a <= n; a++) {
			int b = dn(a);
			if (dn(b) == a && b != a) {
				sum += a;
			}
		}
		return sum;
	}

	public static int method2(int n) {
		int[] dnList = new int[n + 1];
		int sum = 0;

		for (int a = 0; a < dnList.length; a++) {
			dnList[a] = dn(a);
		}

		for (int a = 0; a < dnList.length; a++) {
			int b = dnList[a];
			if (b < dnList.length && dnList[b] == a && b != a) {
				sum += a;
			}
		}
		return sum;
	}

	/*
	 * The naive approach on this method is to just check (n % i == 0) every number
	 * between 2 and n, but that's very inefficient.
	 * Instead, we can check (n % i) == 0 up to i = square root of n. Using this
	 * approach, we can determine half of n's divisors. Since all divisors come in
	 * pairs, we can discover the other half by calculating n / i.
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

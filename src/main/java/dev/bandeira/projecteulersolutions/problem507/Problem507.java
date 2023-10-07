package dev.bandeira.projecteulersolutions.problem507;

/**
 * 
 * Current implementation doesn't work for larger N numbers. Need to learn lattice stuff?
 * @see <a href=
 *      "https://projecteuler.net/problem=507">https://projecteuler.net/problem=507</a>
 * 
 */
public class Problem507 {

	private static final long TEN_TO_THE_SEVENTH = (long) Math.pow(10, 7);
	private static final int MAX_TRIBONACCI = 20_000_000 * 12;
	private static final long[] TRIBONACCI_LOOKUP = new long[MAX_TRIBONACCI];

	public static void main(String[] args) {
		final int n = 1;
		final long smallest = s(n);

		System.out.println("Smallest: " + smallest);

		long sum = 0;
		for (int i = 1; i <= 10; i++) {
			long s = s(i);
			System.out.println("S(%d) = %d".formatted(i, s));
			sum += s;
		}

		System.out.println("Sum: " + sum);
	}

	private static long s(final int n) {
		V v = new V(n);
		W w = new W(n);

		long smallest = Integer.MAX_VALUE;
		for (int k = 0; k <= 50_000; k++) {
			for (int l = 0; l <= 50_000; l++) {
				if (k == 0 && l == 0) {
					continue;
				}
				final long d = d(k, l, v, w);
				smallest = Long.min(smallest, d);
			}
		}
		return smallest;
	}

	private static class V {
		public final int n;
		public final long v1;
		public final long v2;
		public final long v3;

		public V(int n) {
			super();
			this.n = n;

			final int _12n = 12 * n;
			this.v1 = r(_12n - 11) - r(_12n - 10);
			this.v2 = r(_12n - 9) + r(_12n - 8);
			this.v3 = r(_12n - 7) * r(_12n - 6);
		}

		@Override
		public String toString() {
			return "V%d = (%d, %d, %d)".formatted(n, v1, v2, v3);
		}

	}

	private static class W {
		public final int n;
		public final long w1;
		public final long w2;
		public final long w3;

		public W(int n) {
			super();
			this.n = n;

			final int _12n = 12 * n;
			this.w1 = r(_12n - 5) - r(_12n - 4);
			this.w2 = r(_12n - 3) + r(_12n - 2);
			this.w3 = r(_12n - 1) * r(_12n);
		}

		@Override
		public String toString() {
			return "W%d = (%d, %d, %d)".formatted(n, w1, w2, w3);
		}
	}

	private static long tribonacci(final int n) {
		if (n == 0 || n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else if (TRIBONACCI_LOOKUP[n] > 0) {
			return TRIBONACCI_LOOKUP[n];
		} else {
			long tribonacci = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
			TRIBONACCI_LOOKUP[n] = tribonacci;
			return tribonacci;
		}
	}

	private static long r(final int n) {
		return tribonacci(n) % TEN_TO_THE_SEVENTH;
	}

	private static long d(final long k, final long l, final V v, final W w) {
		return Math.abs(k * v.v1 + l * w.w1) + Math.abs(k * v.v2 + l * w.w2) + Math.abs(k * v.v3 + l * w.w3);
	}

}

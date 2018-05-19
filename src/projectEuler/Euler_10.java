package projectEuler;

public class Euler_10 {
	public static void main(String[] args) {
		boolean[] numbers = new boolean[2_000_001];
		long sum = 0;

		for (int i = 2; i < numbers.length; i++) {
			if (!numbers[i]) {
				for (long j = (long) i * i; j < numbers.length; j += i) {
					numbers[(int)j] = true;
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
package projectEuler;

import java.util.HashMap;

public class Euler_12 {
	public static void main(String[] args) {
		Long curNumber = 2l;
		Integer divisors = 1;

		while (divisors < 500) {
			divisors = 1;
			curNumber++;
			Long triangularNmbr = getTriangularNmbr(curNumber);
			Long decoNmbr = triangularNmbr;
			HashMap<Integer, Integer> primeFactors = new HashMap<>();

			while (decoNmbr != 1) {
				for (int i = 2; i <= decoNmbr; i++) {
					if (decoNmbr % i == 0) {
						decoNmbr = decoNmbr / i;
						if (primeFactors.containsKey(i)) {
							primeFactors.put(i, primeFactors.get(i) + 1);
						} else {
							primeFactors.put(i, 1);
						}
						i--;
					}
				}
			}
			Object[] primeDivisors = primeFactors.keySet().toArray();
			for (int i = 0; i < primeDivisors.length; i++) {
				divisors = (primeFactors.get(primeDivisors[i]) + 1) * divisors;
			}

			System.out.println(curNumber + ", " + triangularNmbr + ", " + divisors);
		}

	}

	public static Long getTriangularNmbr(Long i) {
		return i * (i + 1) / 2;
	}
}

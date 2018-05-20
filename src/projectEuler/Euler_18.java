package projectEuler;

/*
 * https://projecteuler.net/problem=18
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom of the triangle below:
 * 
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by
 * trying every route. However, Problem 67, is the same challenge with a
 * triangle containing one-hundred rows; it cannot be solved by brute force, and
 * requires a clever method!
 * 
 * COMPLETED ON 19/05/18
 */
public class Euler_18 {
	/* @formatter:off */
	public static final int[][] TRIANGLE =
			{{75},
			 {95,64},
			 {17,47,82},
			 {18,35,87,10},
			 {20,04,82,47,65},
			 {19,01,23,75,03,34},
			 {88,02,77,73,07,63,67},
			 {99,65,04,28,06,16,70,92},
			 {41,41,26,56,83,40,80,70,33},
			 {41,48,72,33,47,32,37,16,94,29},
			 {53,71,44,65,25,43,91,52,97,51,14},
			 {70,11,33,28,77,73,17,78,39,68,17,57},
			 {91,71,52,38,17,14,91,43,58,50,27,29,48},
			 {63,66,04,68,89,53,67,30,73,16,69,87,40,31},
			 {04,62,98,27,23, 9,70,98,73,93,38,53,60,04,23}};
	/* @formatter:on */

	public static void main(String[] args) {
		int[] chain = new int[TRIANGLE.length];
		int[][] step = copyArray(TRIANGLE);

		chain[14] = 7;

		while (step.length > 1) {
			int indexOfMax = 0;
			int lastIndex;
			step = nextStep(step);
			lastIndex = step.length - 1;

			for (int i = 0; i <= step[lastIndex].length - 1; i++) {
				if (step[lastIndex][i] > step[lastIndex][indexOfMax]) {
					indexOfMax = i;
				}
			}
			chain[lastIndex] = indexOfMax;
		}

		System.out.println(step[0][0]);
	}

	public static int[][] nextStep(int[][] arrayA) {
		int newSize = arrayA.length - 1;
		int[][] arrayB = new int[newSize][];

		for (int i = 0; i < arrayB.length; i++) {
			arrayB[i] = arrayA[i];

		}

		for (int i = 0; i < arrayB.length; i++) {
			arrayB[newSize - 1][i] += arrayA[newSize][i] > arrayA[newSize][i + 1] ? arrayA[newSize][i]
					: arrayA[newSize][i + 1];
		}

		return arrayB;
	}

	public static int[][] copyArray(int[][] arrayA) {
		int[][] arrayB = new int[arrayA.length][];
		for (int i = 0; i < arrayA.length; i++) {
			arrayB[i] = arrayA[i].clone();
		}
		return arrayB;
	}
}

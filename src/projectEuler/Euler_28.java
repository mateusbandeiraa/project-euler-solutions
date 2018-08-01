package projectEuler;

/*
 * Starting with the number 1 and moving to the right in a clockwise direction a
 * 5 by 5 spiral is formed as follows:
 * 
 * 21 22 23 24 25
 * 20 07 08 09 10
 * 19 06 01 02 11
 * 18 05 04 03 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 * 
 * COMPLETED ON: 01/08/18
 */
public class Euler_28 {

	private static final int GRID_SIZE = 1001;
	private static int[][] grid = new int[GRID_SIZE][GRID_SIZE];

	public static void main(String[] args) {
		fill();

		System.out.println("The sum is: " + (mainDiagonalSum() + (secondaryDiagonalSum() - 1)));
		// We have to subtract 1 from SecondaryDiagonalSum because it intersects with
		// the main diagonal always on the middle.
	}

	private static void fill() {
		int currentValue = GRID_SIZE * GRID_SIZE;
		int leftTurns, downTurns, rightTurns, upTurns;
		int initialIndex = GRID_SIZE / 2;
		int xIndex = GRID_SIZE;
		int yIndex = 0;

		leftTurns = downTurns = rightTurns = upTurns = initialIndex;

		while (currentValue >= 1) {
			if (leftTurns >= downTurns && leftTurns >= rightTurns && leftTurns >= upTurns) {
				while (xIndex > 0 && xIndex <= GRID_SIZE && yIndex >= 0 && yIndex < GRID_SIZE
						&& grid[yIndex][xIndex - 1] == 0) {
					xIndex--;
					grid[yIndex][xIndex] = currentValue;
					currentValue--;
				}
				leftTurns--;
			} else if (downTurns >= rightTurns && downTurns >= upTurns) {
				while (xIndex >= 0 && xIndex < GRID_SIZE && yIndex >= 0 && yIndex < (GRID_SIZE - 1)
						&& grid[yIndex + 1][xIndex] == 0) {
					yIndex++;
					grid[yIndex][xIndex] = currentValue;
					currentValue--;
				}
				downTurns--;
			} else if (rightTurns >= upTurns) {
				while (xIndex >= 0 && xIndex < (GRID_SIZE - 1) && yIndex >= 0 && yIndex < GRID_SIZE
						&& grid[yIndex][xIndex + 1] == 0) {
					xIndex++;
					grid[yIndex][xIndex] = currentValue;
					currentValue--;
				}
				rightTurns--;
			} else {
				while (xIndex >= 0 && xIndex < GRID_SIZE && yIndex > 0 && yIndex < GRID_SIZE
						&& grid[yIndex - 1][xIndex] == 0) {
					yIndex--;
					grid[yIndex][xIndex] = currentValue;
					currentValue--;
				}
				upTurns--;
			}
		}

	}

	private static int mainDiagonalSum() {
		int sum = 0;
		for (int i = 0; i < GRID_SIZE; i++) {
			sum += grid[i][i];
		}

		return sum;
	}

	private static int secondaryDiagonalSum() {
		int sum = 0;

		int j = GRID_SIZE - 1;

		for (int i = 0; i < GRID_SIZE; i++) {
			sum += grid[i][j];
			j--;
		}

		return sum;
	}

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixMaxSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine(); // number of rows
		List<int[]> dynamicMatrix = new ArrayList<int[]>();

		// allocate dynamic matrix
		for (int i = 0; i < n; i++) {
			String[] humanInput = in.nextLine().split(" ");
			dynamicMatrix.add(i, toIntArray(humanInput));

		}

		/// Converts String coordinates to int array
		String[] coordinatesString = in.nextLine().split(" ");
		int[] coord = new int[coordinatesString.length];
		for (int i = 0; i < coordinatesString.length; i++) {
			coord[i] = Integer.parseInt(coordinatesString[i]);
		}

		System.out.println(gimnastika(coord, dynamicMatrix));

	}

	static long gimnastika(int[] coord, List<int[]> matrix) {

		long finalResult = Long.MIN_VALUE; // always set results to MIN.VALUE if working with negative numbers

		for (int i = 1; i < coord.length; i += 2) {
			int a, b;
			boolean negativeA = false, negativeB = false; // watches out for negative 0 index

			// Coordinates checkers, turns them into indexes for easy access
			if (coord[i - 1] > 0) {
				a = coord[i - 1] - 1;
			} else {
				negativeA = true;
				a = coord[i - 1] + 1;
			}

			if (coord[i] > 0) {
				b = coord[i] - 1;
			} else {
				negativeB = true;
				b = coord[i] + 1;
			}

			int positiveA = Math.abs(a);
			int positiveB = Math.abs(b);
			int currentCoordMax = 0;

			// When first coordinate (a) is a positive num
			if (a >= 0 && !negativeA) {

				for (int c = 0; c <= positiveB; c++) {
					currentCoordMax += matrix.get(a)[c];
				}

				// If b is a positive number, negativeB indicates if there is a negative 0 index
				if (b >= 0 && !negativeB) {
					currentCoordMax += goUp(matrix, a, b);
				} else {
					currentCoordMax += goDown(matrix, a, positiveB);
				}

				finalResult = Math.max(finalResult, currentCoordMax);

			} else { // when a is negative num

				for (int c = matrix.get(0).length - 1; c >= positiveB; c--) {
					currentCoordMax += matrix.get(positiveA)[c];
				}

				// If b is a positive number, negativeB indicates if there is a negative 0 index
				if (b >= 0 && !negativeB) {
					currentCoordMax += goUp(matrix, positiveA, b);
				} else {
					currentCoordMax += goDown(matrix, positiveA, positiveB);
				}

				finalResult = Math.max(finalResult, currentCoordMax);
			}

		}
		return finalResult;

	}

	static int goUp(List<int[]> matrix, int a, int b) {
		int sumFromGoingUp = 0;
		for (int i = a - 1; i >= 0; i--) {
			sumFromGoingUp += matrix.get(i)[b];
		}
		return sumFromGoingUp;
	}

	static int goDown(List<int[]> matrix, int a, int b) {
		int sumFromGoingDown = 0;
		for (int i = a + 1; i < matrix.size(); i++) {
			sumFromGoingDown += matrix.get(i)[b];
		}
		return sumFromGoingDown;
	}

	static int[] toIntArray(String[] input) {
		int[] finalArray = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			finalArray[i] = Integer.parseInt(input[i]);
		}

		return finalArray;
	}
}

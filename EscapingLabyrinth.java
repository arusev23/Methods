
public class EscapingLabyrinth {

	public static boolean inRange(int value, int max) {
		return 0 <= value && value < max;
	}

	public static void main(String[] args) {
		char[][] lab = { { 'x', ' ', ' ', ' ', ' ', 'x' }, { 'x', ' ', 'x', 'x', ' ', 'x' },
				{ 'x', 's', 'x', 'x', ' ', 'x' }, { 'x', 'x', 'x', ' ', ' ', 'x' }, { 'x', ' ', 'x', ' ', ' ', 'x' },
				{ 'x', ' ', 'x', ' ', 'e', 'x' }, { 'x', ' ', ' ', ' ', ' ', 'x' }, { 'x', 'x', 'x', 'x', 'x', 'x' } };
		int r = 2, c = 1;
		System.out.println(hasExit(lab, r, c));

	}

	public static boolean hasExit(char[][] lab, int row, int col) {
		int rows = lab.length;
		int cols = lab[row].length;

		int[] dRows = { +1, 0, -1, 0 };
		int[] dCols = { 0, +1, 0, -1 };

		// if next is 's' or 'x' cont
		// if next is 'e' return true
		//

		for (int dir = 0; dir < dRows.length; dir++) {
			int nextRow = row + dRows[dir];
			int nextCol = col + dCols[dir];

			// if out of bounds
			if (!inRange(nextRow, rows) || !inRange(nextCol, cols)) {
				continue;
			}

			// if visited or wall
			if (lab[nextRow][nextCol] == 'x') {
				continue;
			}

			// if end
			if (lab[nextRow][nextCol] == 'e') {
				return true;
			}

			lab[nextRow][nextCol] = 'x'; // marks the step
			// recursive call with nextPosition
			boolean hasPath = hasExit(lab, nextRow, nextCol);
			lab[nextRow][nextCol] = ' '; // unmarks the step

			if (hasPath) {
				return true;
			}
		}
		return false;

	}
}

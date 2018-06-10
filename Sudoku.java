import java.util.Scanner;

public class Sudoku {

	static int[][] sudoku = new int[9][9];

	public static void main(String[] args) {

		fillSudoku(sudoku);
		solveSudoku(0, 0);

	}

	static void solveSudoku(int currentRow, int currentCol) {

		if (currentRow == 9 && currentCol == 0) {
			printSudoku(sudoku);

		} else if (sudoku[currentRow][currentCol] == 0) {
			for (int i = 1; i <= 9; i++) {

				if (checkRow(currentRow, i) || checkCol(currentCol, i) || checkSquare(currentRow, currentCol, i)) {
					continue;
				}

				sudoku[currentRow][currentCol] = i;
				solveSudoku(nextRow(currentRow, currentCol), nextCol(currentCol));
				sudoku[currentRow][currentCol] = 0; // при връщането на рекурсията да върне и да попълна отново
			}
		} else {
			// като връща назад числото няма да е 0
			solveSudoku(nextRow(currentRow, currentCol), nextCol(currentCol));
		}

	}

	static boolean checkRow(int row, int number) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	static boolean checkCol(int col, int number) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][col] == number) {
				return true;
			}
		}
		return false;
	}

	static boolean checkSquare(int row, int col, int number) {
		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;

		for (int i = startRow; i < startRow + 3; i++) {

			for (int j = startCol; j < startCol + 3; j++) {

				if (sudoku[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}

	static int nextRow(int row, int col) {
		col++;
		if (col > 8) {

			return row + 1;
		}

		return row;
	}

	static int nextCol(int col) {
		col++;
		if (col > 8) {

			return 0;
		}

		return col;
	}

	static void printSudoku(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {

				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}

	static void fillSudoku(int[][] sudoku) {
		Scanner in = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {

			String line = in.nextLine();
			for (int j = 0; j < 9; j++) {

				// puts in given starting numbers at their position
				// everything else is zeroes
				if (line.charAt(j) != '-') {
					sudoku[i][j] = line.charAt(j) - '0';
				}
			}
		}
	}
}

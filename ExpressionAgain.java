import java.util.ArrayList;
import java.util.Scanner;

public class ExpressionAgain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int value = in.nextInt();

		ArrayList<Integer> digits = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			digits.add(input.charAt(i) - '0');
		}

		int count = 0;
		int number = 0;

		// 1, 12, 123, 1234

		for (int i = 0; i < digits.size(); i++) {
			number = 10 * number + digits.get(i);
			// int pos = i + 1;
			if (i > 0 && number == 0) {
				break;
			}
			count += generateExpressions(digits, i + 1, number, value);

		}

		System.out.println(count);

	}

	static int generateExpressions(ArrayList<Integer> digits, int index, int currentSum, int targetSum) {

		// if all numbers are checked
		if (index == digits.size()) {
			if (currentSum == targetSum) {
				return 1;
			}
			return 0; // target sum not found
		}

		int count = 0;
		int number = 0;
		for (int i = index; i < digits.size(); i++) {

			number = 10 * number + digits.get(i);

			count += generateExpressions(digits, i + 1, currentSum + number, targetSum);
			count += generateExpressions(digits, i + 1, currentSum - number, targetSum);
			count += generateExpressions(digits, i + 1, currentSum * number, targetSum);
			if (number == 0) {
				break;
			}
		}

		return count;
	}

}
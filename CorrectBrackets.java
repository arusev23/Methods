import java.util.LinkedHashSet;
import java.util.Scanner;

public class CorrectBrackets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		LinkedHashSet<String> forPrint = generateExpression("", n);

		for (String s : forPrint) {
			System.out.println(s);
		}
		// prints the counter at the end
		System.out.println(counter);
	}

	static LinkedHashSet<String> brackets = new LinkedHashSet<String>();
	static int counter = 0; // counts how many times the function is called

	static LinkedHashSet<String> generateExpression(String expression, int n) {
		counter++;
		if (expression.length() == n) {
			brackets.add(expression);

			return brackets;
		}

		LinkedHashSet<String> currentBrackets = generateExpression(expression + "()", n);
		brackets.addAll(currentBrackets);

		generateExpression("()" + expression, n);
		brackets.addAll(currentBrackets);

		currentBrackets = generateExpression("(" + expression + ")", n);
		brackets.addAll(currentBrackets);

		return brackets;
	}
}

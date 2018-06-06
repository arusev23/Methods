import java.util.HashSet;
import java.util.Scanner;

public class CorrectBrackets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		HashSet<String> forPrint = generateExpression("", n);

		for (String s : forPrint) {
			System.out.println(s);
		}
		// printer with iterator
		// Iterator<String> it = brackets.iterator();
		// while (it.hasNext()) {
		// System.out.println(it.next());
		// }
	}

	static HashSet<String> brackets = new HashSet<String>();

	static HashSet<String> generateExpression(String expression, int n) {

		if (expression.length() == n) {
			brackets.add(expression);

			return brackets;
		}

		HashSet<String> currentBrackets = generateExpression(expression + "()", n);
		brackets.addAll(currentBrackets);

		currentBrackets = generateExpression("(" + expression + ")", n);
		brackets.addAll(currentBrackets);

		generateExpression("()" + expression, n);
		brackets.addAll(currentBrackets);

		return brackets;
	}
}

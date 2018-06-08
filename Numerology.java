import java.util.ArrayList;
import java.util.Scanner;

public class Numerology {

	static int[] digitCount = new int[10];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String inputNumber = in.nextLine();
		ArrayList<Integer> digits = new ArrayList<>();
		for (int i = 0; i < inputNumber.length(); i++) {
			digits.add(inputNumber.charAt(i) - '0');
		}

		Divine(digits);
		String finalOutput = "";
		for (int el : digitCount) {
			finalOutput += el + " ";
		}
		System.out.println(finalOutput.trim());

	}

	public static void Divine(ArrayList<Integer> digits) {
		if (digits.size() == 1) {
			digitCount[digits.get(0)]++;
			return;
		}

		for (int i = 1; i < digits.size(); i++) {
			int a = digits.get(i - 1);
			int b = digits.get(i);
			digits.remove(i);
			digits.set(i - 1, Magic(a, b));

			Divine(digits);

			digits.set(i - 1, a);
			digits.add(i, b);
		}
	}

	public static int Magic(int a, int b) {
		return (a + b) * (a ^ b) % 10;
	}
}

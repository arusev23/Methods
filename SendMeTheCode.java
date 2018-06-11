import java.util.ArrayList;
import java.util.Scanner;

public class SendMeTheCode {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine(); // 569
		ArrayList<Integer> digits = new ArrayList<>();
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

		long result = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 45) {
				continue;
			}
			int digit = input.charAt(i) - '0';
			digits.add(digit);
		}
		int index = digits.size();

		for (int i = 0; i < digits.size(); i++) {

			if (index % 2 == 0) {
				result += (digits.get(i) * digits.get(i)) * index;
			} else {
				result += digits.get(i) * (index * index);
			}
			index--;
		}

		System.out.println(result);

		int lastDigit = (int) (result % 10);
		if (lastDigit == 0) {
			System.out.println("BigVik wins again!");
		} else {
			int lengthOfMessage = lastDigit;
			int holder = (int) (result % 26);
			int end = holder + lengthOfMessage;
			final int last = alphabet.length;
			for (int z = holder; z < holder + lengthOfMessage; z++) {
				char res = (alphabet[z % last]);
				System.out.print(res);
			}

			// System.out.println(result);

		}
	}
}

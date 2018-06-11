import java.util.ArrayList;
import java.util.Scanner;

public class AandB {
	static ArrayList<String> result = new ArrayList<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		String[] humanInput = in.nextLine().split(" ");

		possibleStrings(n, humanInput, "", result);
		result.sort(null);
		result.forEach(System.out::println);

	}

	public static void possibleStrings(int maxLength, String[] alphabet, String curr, ArrayList<String> result) {

		// If the current string has reached it's maximum length
		if (curr.length() == maxLength) {
			result.add(curr);

			// Else add each letter from the alphabet to new strings and process these new
			// strings again
		} else {
			for (int i = 0; i < alphabet.length; i++) {
				String oldCurr = curr;
				curr += alphabet[i];
				possibleStrings(maxLength, alphabet, curr, result);
				curr = oldCurr;
			}
		}
	}
}

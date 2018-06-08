import java.util.ArrayList;
import java.util.Scanner;

public class GenerateAllPermutations {
	static ArrayList<String> collection = new ArrayList<>();

	static void permute(ArrayList<String> arr, int k) {
		for (int i = k; i < arr.size(); i++) {
			java.util.Collections.swap(arr, i, k);
			permute(arr, k + 1);
			java.util.Collections.swap(arr, k, i);
		}
		if (k == arr.size() - 1) {
			// java.util.Collections.sort(arr);
			collection.add(arr.toString());
		}
		collection.sort(null);
		// return collection;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		ArrayList<String> input = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			input.add(Integer.toString(i));
		}

		permute(input, 0);
		for (String lineTokens : collection) {
			System.out.println(lineTokens);
		}

	}
}

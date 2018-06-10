import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class getPermutations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		var permutation = Stream.generate(() -> 0).limit(n).collect(Collectors.toList());
		var permutations = new ArrayList<List<Integer>>();

		int counter = 0;
		int println = 0;
		getAllPermutations(0, n, permutation, new HashSet<>(), permutations);
		for (List<Integer> permu : permutations) {
			counter = 0;
			for (Integer digits : permu) {
				counter++;
				if (counter < permu.size()) {
					System.out.print(digits + " ");
				} else {
					System.out.print(digits);
				}
			}
			println++;
			if (println < permutations.size()) {
				System.out.println();
			}

		}
	}

	public static void getAllPermutations(int index, int n, List<Integer> permutation, HashSet<Integer> used,
			ArrayList<List<Integer>> permutations) {

		if (index == n) {
			permutations.add(new ArrayList<>(permutation));
			return;
		}

		for (int value = 1; value < n + 1; value++) {
			if (used.contains(value)) {
				continue;
			}

			used.add(value);

			permutation.set(index, value);

			getAllPermutations(index + 1, n, permutation, used, permutations);

			used.remove(value);
		}
	}
}

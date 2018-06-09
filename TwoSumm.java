import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

//With Brute-force

public class TwoSumm {

	static void fakeInput() {
		String test = "3 2 4\n" + "6";
		System.setIn(new ByteArrayInputStream(test.getBytes()));
	}

	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		fakeInput();
		Scanner in = new Scanner(System.in);
		int[] numbers = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int target = in.nextInt();

		int[] endResult = twoSum(numbers, target);
		System.out.println(Arrays.toString(endResult));
	}
}

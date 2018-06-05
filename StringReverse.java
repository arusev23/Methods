
public class StringReverse {
	public static void main(String[] args) {

		System.out.println(reverse("Rolex is expensive"));
	}

	public static String reverse(String input) {
		if (input.length() == 0) {
			return input;
		}

		return reverse(input.substring(1)) + input.charAt(0);
	}
}

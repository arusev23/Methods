
public class StringReverse {
	public static void main(String[] args) {

		System.out.println(reverse("Rolex is expensive"));
	}

	public static String reverse(String str) {
		if (str.length() == 0) {
			return str;
		}

		return reverse(str.substring(1)) + str.charAt(0);
	}
}

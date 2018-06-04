import java.util.Scanner;

public class numbersTriangle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		trianglesPrinter(n);
	}
	
	static void trianglesPrinter(int number) {

		for(int i = 1; i <= number; i++) {
			
			for (int j = 1; j < i; j++) {
				System.out.print(j + " ");
			}
			
			System.out.print(i);
			
			System.out.println();
			
		}
		
		for (int i = (number - 1); i >= 1; i--) {
			
			for (int j = 1; j < i; j++) {
				System.out.print(j + " ");
			}
			
			System.out.print(i);
			
			System.out.println();
			
		}
		
	}
}

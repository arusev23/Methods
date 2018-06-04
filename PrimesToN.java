import java.util.ArrayList;
import java.util.Scanner;

public class PrimesToN {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		printPrimeTo(n).forEach(x->{
			if (x.equals(printPrimeTo(n).get(printPrimeTo(n).size() - 1))){ // if X is last element of list
				System.out.print(x);
			}
			else System.out.print(x + " ");
		}
		);
	}
	
	static ArrayList<Integer> printPrimeTo(int number){
		ArrayList<Integer> primeNumbers = new ArrayList<>();
		
		for (int i = 1; i <= number; i++) {
			if(isPrimeNumber(i)) {
				primeNumbers.add(i);
			}
		}
		
		return primeNumbers;
	}
	
    public static boolean isPrimeNumber(int number) {
   
    	for (int i = 2; i <= Math.sqrt(number); i++) {
    		if (number % i == 0) {
    			return false;
    		}
    	}
    	
    	return true;
  }
}

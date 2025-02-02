/*4. Factorial Calculation:
 Write a function to calculate the factorial of a number.*/


package sunday.practice;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int userRange = 0;
		int fact = 1;
		
		while (userRange == 0) {
			System.out.printf("Enter number: ");
			userRange = sc.nextInt();
			if (userRange == 0 && userRange > -1) {
				System.out.println("Range cannot be Zero!");
				System.out.println("\nRetry...");
			} else if (userRange < 0) {
				System.out.println("Range cannot be Negative!");
				System.out.println("\nRetry...");
				userRange = 0;
			} else {
				break;
			}
		}
		
		if (userRange==1 && userRange < 2) {
			System.out.println("\nFactorial of "+userRange+" is: "+fact);
		} else {
			for (int i=1; i<=userRange; i++) {
				fact = fact * i;
			}
			System.out.println("\nFactorial of "+userRange+" is: "+fact);
		}
		
		sc.close();
	}

}

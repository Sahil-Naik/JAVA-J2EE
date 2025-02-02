/*6. Check for Prime Number:
 Write a program to check if a given number is prime.*/

package sunday.practice;

import java.util.Scanner;

class PrimeNumberCheck {
	static boolean isPrime(int n) {
		// Corner case
		if (n <= 1)
			return false;

		// Check from 2 to n-1
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;

		return true;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int userNumber = 0;
		
		
		while (userNumber == 0) {
			System.out.printf("Enter a Number: ");
			userNumber = sc.nextInt();
			if (userNumber == 0 && userNumber > -1) {
				System.out.println("Number cannot be Zero!");
				System.out.println("\nRetry...");
			} else if (userNumber < 0) {
				System.out.println("Number cannot be Negative!");
				System.out.println("\nRetry...");
				userNumber = 0;
			} else {
				break;
			}
		}
		
		if (isPrime(userNumber)) {
			System.out.println("\n"+userNumber+" is a Prime Number!");
		} else {
			System.out.println("\n"+userNumber+" is not a Prime Number!");
		}
		
		sc.close();
	}
}
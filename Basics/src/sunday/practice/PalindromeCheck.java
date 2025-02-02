/*3. Check for Palindrome:
 Determine if a given string is a palindrome (reads the same backward as forward).*/

package sunday.practice;

import java.util.Scanner;

public class PalindromeCheck {

	public static String Reverse(String str) {
		String reversed = new StringBuilder(str).reverse().toString();

		return reversed;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String userString, reverseduserString;

		System.out.printf("Enter a string: ");
		userString = sc.next();

		reverseduserString = Reverse(userString);

		if (userString.toUpperCase().equals(reverseduserString.toUpperCase())) {
			System.out.println("\nGiven string is a Palindrome");
			System.out.println("Original String: " + userString.toUpperCase() + "\nReversed String: "
					+ reverseduserString.toUpperCase());
		} else {
			System.out.println("\nGiven string is not a Palindrome");
			System.out.println("Original String: " + userString.toUpperCase() + "\nReversed String: "
					+ reverseduserString.toUpperCase());
		}
		
		sc.close();
	}

}

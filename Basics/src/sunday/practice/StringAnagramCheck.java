/*7. String Anagrams:
 Determine if two strings are anagrams of each other.*/

package sunday.practice;

import java.util.Arrays;
import java.util.Scanner;

public class StringAnagramCheck {
	public static boolean areAnagrams(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();

		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		return Arrays.equals(charArray1, charArray2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String userString1, userString2;

		System.out.printf("Enter first string: ");
		userString1 = sc.next();

		System.out.printf("\nEnter second string: ");
		userString2 = sc.next();
		
		userString1 = userString1.toUpperCase();
		userString2 = userString2.toUpperCase();
		
		System.out.println("");
		if (areAnagrams(userString1, userString2)) {
			System.out.println(userString1 + " and " + userString2 + " are anagrams.");
		} else {
			System.out.println(userString1 + " and " + userString2 + " are not anagrams.");
		}
		
		sc.close();
	}
}

/*1. Reverse a String:
	 Write a Java program to reverse a given string.*/

package sunday.practice;

import java.util.Scanner;


public class ReverseString {
	
	public static String Reverse(String str) {
		String reversed = new StringBuilder(str).reverse().toString();
		
		return reversed;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String userString;
		
		System.out.printf("Enter a string: ");
		userString = sc.next();
		
		System.out.println("\nOriginal String: "+userString+"\nReversed String: "+Reverse(userString));
		
		sc.close();
	}
}

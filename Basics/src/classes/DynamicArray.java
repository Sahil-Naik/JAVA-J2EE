package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArray {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> myNumbers = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		int countNumber = 0;
		int userNumber = 0;
		
		System.out.println("How many numbers to add: ");
		countNumber = scanner.nextInt();
		
		System.out.println("\n");
		
		for(int i=0; i<countNumber; i++) {
			System.out.println("Enter element:");
			userNumber = scanner.nextInt();
			myNumbers.add(userNumber);
		}
		
		System.out.println("\nNumbers are: " + myNumbers);		
		
		scanner.close();
	}

}

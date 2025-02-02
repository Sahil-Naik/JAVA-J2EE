/*10. Duplicate Elements in an Array:
 Find and print duplicate elements in an array.*/


package sunday.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DuplicateEntriesCheck {
	public static void findDuplicates(ArrayList<Integer> arr) {
		Collections.sort(arr); // O(N log N)
		ArrayList<Integer> duplicates = new ArrayList<>();

		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i).equals(arr.get(i - 1)) && !duplicates.contains(arr.get(i))) {
				duplicates.add(arr.get(i));
			}
		}

		if (duplicates.size() == 0) {
			System.out.println("There are not Duplicate entires!");
		} else {
			System.out.println("Duplicate elements: " + duplicates);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int userArraySize = 0;
		int arrayElement = 0;
		ArrayList<Integer> userArray = new ArrayList<Integer>();

		while (userArraySize == 0) {
			System.out.printf("Enter size of array: ");
			userArraySize = sc.nextInt();
			if (userArraySize == 0 && userArraySize > -1) {
				System.out.println("Array size cannot be Zero!");
				System.out.println("\nRetry...");
			} else if (userArraySize < 0) {
				System.out.println("Array size cannot be Negative!");
				System.out.println("\nRetry...");
				userArraySize = 0;
			} else {
				break;
			}
		}
		System.out.println("");
		for (int i = 1; i <= userArraySize; i++) {
			System.out.printf("Enter Element number " + i + ": ");
			arrayElement = sc.nextInt();
			userArray.add(arrayElement);
		}

		System.out.println("\nUser array is: " + userArray);
		findDuplicates(userArray);

		sc.close();
	}
}

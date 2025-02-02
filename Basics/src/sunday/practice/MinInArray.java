/*2b. Find the Smallest Element in an Array:
 Find and print the largest element in an array.*/

package sunday.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class MinInArray {

	public static int FindMin(ArrayList<Integer> arr) {
		int minimum = Integer.MAX_VALUE;

		if (arr.size() > 1) {
			for (int i = 0; i < arr.size(); i++) {
				if (minimum > arr.get(i)) {
					minimum = arr.get(i);
				} else {
					continue;
				}
			}
		} else {
			for (int i = 0; i < arr.size(); i++) {
				if (minimum < arr.get(i)) {
					minimum = arr.get(i);
				} else {
					continue;
				}
			}
			System.out.println("\nThere is only 1 element in the array -_-\nSo its by default the largest and the smallest.");
			System.out.println("Pretty cool paradox if you ask me. #Duh #getgood");
		}
		return minimum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int userArraySize = 0;
		int arrayElement = 0;
		ArrayList<Integer> userArray = new ArrayList<Integer>();
		
		while (userArraySize==0) {
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
		for (int i=1; i<=userArraySize; i++) {
			System.out.printf("Enter Element number "+i+": ");
			arrayElement = sc.nextInt();
			userArray.add(arrayElement);
		}
		
		System.out.println("\nUser array is: "+userArray);
		System.out.println("\nMinimum number from array is: "+FindMin(userArray));
		
		sc.close();
	}

}

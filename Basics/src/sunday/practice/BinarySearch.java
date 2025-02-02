/*9. Binary Search:
 Implement a binary search algorithm to find an element in a sorted array.*/


package sunday.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {
	public static int binarySearch(ArrayList<Integer> arr, int low, int high, int target) {
        if (low > high) {
            return -1; // Base case: target not found
        }

        int mid = low + (high - low) / 2;

        if (arr.get(mid) == target) {
            return mid;
        } else if (arr.get(mid) < target) {
            return binarySearch(arr, mid + 1, high, target);
        } else {
            return binarySearch(arr, low, mid - 1, target);
        }
    }
	
	// Driver method to test above
		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);

			int userArraySize = 0, userTarget=0;
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
			
			System.out.printf("\nEnter number to search: ");
			userTarget = sc.nextInt();
			
			System.out.println("\nArray: "+userArray);
			int index = binarySearch(userArray, 0, userArraySize, userTarget);
			System.out.println("Target " + userTarget + " found at index: " + index);
			
			sc.close();
		}
}

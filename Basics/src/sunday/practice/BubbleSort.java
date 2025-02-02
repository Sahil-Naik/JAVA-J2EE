/*8a. Array Sorting:
 Implement sorting algorithm bubble sort.*/

package sunday.practice;

import java.util.ArrayList;
import java.util.Scanner;

class BubbleSort {
	public static ArrayList<Integer> sorting(ArrayList<Integer> arr) {
        int n = arr.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {  // Correct comparison
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        return arr;
    }

	// Driver method to test above
	public static void main(String args[]) {
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
		
		System.out.println("\nOriginal Array: "+userArray);
		userArray = sorting(userArray);
		System.out.println("\nSorted Array: "+userArray);
		
		sc.close();
	}
	
}

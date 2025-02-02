/*8c. Array Sorting:
 Implement sorting algorithm quick sort.*/

package sunday.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {
	public static void quickSort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after the partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high); // Choosing last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // Swap pivot into its correct position
        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1; // Return pivot index
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
 		quickSort(userArray, 0, userArraySize-1);
 		System.out.println("\nSorted Array: "+userArray);
 		
 		sc.close();
 	}
}

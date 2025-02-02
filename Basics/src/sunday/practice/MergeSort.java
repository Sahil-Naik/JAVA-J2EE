/*8b. Array Sorting:
 Implement sorting algorithm merge sort.*/

package sunday.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
		if (arr.size() <= 1) {
			return arr; // Base case: already sorted
		}

		int mid = arr.size() / 2;

		// Split the array into left and right halves
		ArrayList<Integer> left = new ArrayList<>(arr.subList(0, mid));
		ArrayList<Integer> right = new ArrayList<>(arr.subList(mid, arr.size()));

		// Recursively sort both halves
		left = mergeSort(left);
		right = mergeSort(right);

		// Merge the sorted halves
		return merge(left, right);
	}

	private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge two sorted lists
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Add remaining elements from both halves
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
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
			userArray = mergeSort(userArray);
			System.out.println("\nSorted Array: "+userArray);
			
			sc.close();
		}
}

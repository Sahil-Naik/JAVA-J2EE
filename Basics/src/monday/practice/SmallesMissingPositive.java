// Find the smallest positive missing number in an unsorted array

package monday.practice;

public class SmallesMissingPositive {
	public static void main(String[] args) {
        int[] arr = {1 ,2, 4, -1, 1};
        int smallestMissing = findSmallestMissingPositive(arr);
        System.out.println("The smallest positive missing number is: " + smallestMissing);
    }

    public static int findSmallestMissingPositive(int[] arr) {
        int n = arr.length;

        // Step 1: Place each number in its right place
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] with arr[arr[i] - 1]
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Step 2: Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1; // The smallest missing positive
            }
        }

        // If all numbers from 1 to n are present, return n + 1
        return n + 1;
    }
}

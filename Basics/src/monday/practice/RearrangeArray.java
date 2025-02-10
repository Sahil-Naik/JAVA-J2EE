// Rearrange an array such that even index elements are greater than odd index elements

package monday.practice;

public class RearrangeArray {
	public static void main(String[] args) {
        int[] arr = {10, 5, 6, 3, 8, 2, 7, 1};
        
        rearrangeArray(arr);
        
        // Print the rearranged array
        System.out.print("Rearranged array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void rearrangeArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // If the index is even
            if (i % 2 == 0) {
                // If the current element is less than or equal to the next element
                if (arr[i] <= arr[i + 1]) {
                    // Swap the elements
                    swap(arr, i, i + 1);
                }
            } else { // If the index is odd
                // If the current element is greater than or equal to the next element
                if (arr[i] >= arr[i + 1]) {
                    // Swap the elements
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Count the number of inversion pairs in an array
// An inversion pair in an array is a pair of indices ( (i, j) ) such that ( i < j ) and ( arr[i] > arr[j] ).

package monday.practice;

public class InversionArray {
	public static void main(String[] args) {
		int[] arr = { 1, 20, 6, 4, 5 };
		int inversionCount = countInversions(arr);
		System.out.println("Number of inversions: " + inversionCount);
	}

	public static int countInversions(int[] arr) {
		return mergeSortAndCount(arr, 0, arr.length - 1);
	}

	private static int mergeSortAndCount(int[] arr, int left, int right) {
		int count = 0;
		if (left < right) {
			int mid = (left + right) / 2;

			count += mergeSortAndCount(arr, left, mid); // Count inversions in left half
			count += mergeSortAndCount(arr, mid + 1, right); // Count inversions in right half
			count += mergeAndCount(arr, left, mid, right); // Count inversions while merging
		}
		return count;
	}

	private static int mergeAndCount(int[] arr, int left, int mid, int right) {
		int[] leftArray = new int[mid - left + 1];
		int[] rightArray = new int[right - mid];

		// Copy data to temporary arrays
		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = arr[left + i];
		}
		for (int j = 0; j < rightArray.length; j++) {
			rightArray[j] = arr[mid + 1 + j];
		}

		int i = 0, j = 0, k = left, count = 0;

		// Merge the two arrays and count inversions
		while (i < leftArray.length && j < rightArray.length) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k++] = leftArray[i++];
			} else {
				// There are mid - i inversions, because all remaining elements in leftArray
				// (from leftArray[i] to leftArray[mid]) are greater than rightArray[j]
				arr[k++] = rightArray[j++];
				count += (mid + 1) - (left + i);
			}
		}

		// Copy remaining elements of leftArray, if any
		while (i < leftArray.length) {
			arr[k++] = leftArray[i++];
		}

		// Copy remaining elements of rightArray, if any
		while (j < rightArray.length) {
			arr[k++] = rightArray[j++];
		}

		return count;
	}
}

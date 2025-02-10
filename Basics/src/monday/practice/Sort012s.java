package monday.practice;

public class Sort012s {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 0, 1, 2, 1, 0, 2 };

		sort012(arr);

		// Print the sorted array
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	public static void sort012(int[] arr) {
		int low = 0; // Pointer for the next position of 0
		int mid = 0; // Pointer for the current element
		int high = arr.length - 1; // Pointer for the next position of 2

		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				// Swap arr[low] and arr[mid]
				swap(arr, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				// Swap arr[mid] and arr[high]
				swap(arr, mid, high);
				high--;
				break;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

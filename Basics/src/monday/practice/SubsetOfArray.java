package monday.practice;

public class SubsetOfArray {
	
	static boolean isSubset(int[] a, int[] b) {
        // Iterate over each element in the second array
        int m = a.length;
        int n = b.length;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            // Check if the element exists in the first array
            for (int j = 0; j < m; j++) {
                if (b[i] == a[j]) {
                    found = true;
                    break;
                }
            }
            // If any element is not found, return false
            if (!found) return false;
        }
        // If all elements are found, return true
        return true;
    }

    public static void main(String[] args) {
        int[] a = {11, 1, 13, 21, 3, 7};
        int[] b = {11, 3, 7, 1};

        if (isSubset(a, b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}

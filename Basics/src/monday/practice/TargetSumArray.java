// Find a pair of numbers in an array that sum up to a given target

package monday.practice;

import java.util.HashSet;

public class TargetSumArray {
	public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        int[] result = findPairWithSum(arr, target);
        if (result != null) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found that sums up to " + target);
        }
    }

    public static int[] findPairWithSum(int[] arr, int target) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seenNumbers.contains(complement)) {
                return new int[]{complement, num}; // Return the pair
            }
            seenNumbers.add(num);
        }

        return null; // Return null if no pair is found
    }
}

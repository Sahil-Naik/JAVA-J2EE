package monday.practice;

import java.util.HashSet;

public class LongestSequence {
	public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longestSequence = findLongestConsecutiveSequence(nums);
        System.out.println("The length of the longest consecutive sequence is: " + longestSequence);
    }

    public static int findLongestConsecutiveSequence(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : nums) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}

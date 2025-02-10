package monday.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FirstNonRepeating {
	
	public static Integer findFirstNonRepeating(List<Integer> numbers) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each element
        for (Integer num : numbers) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Find the first non-repeating element
        for (Integer num : numbers) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }

        // Return null if no non-repeating element is found
        return null;
    }
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5, 3, 8, 5, 2, 8, 7, 4);

		Integer firstNonRepeating = findFirstNonRepeating(numbers);
        if (firstNonRepeating != null) {
            System.out.println("The first non-repeating element is: " + firstNonRepeating);
        } else {
            System.out.println("There are no non-repeating elements.");
        }
	}	

}

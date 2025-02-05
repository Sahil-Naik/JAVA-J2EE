package milestone.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupString {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("one", "tttttt", "fig", "grape", "kiwi", "noice", "date", "pear");
		Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length)); // Group by the length of each word

        // Print the grouped words
        groupedByLength.forEach((length, wordList) -> 
            System.out.println("Length " + length + ": " + wordList));
	}
}

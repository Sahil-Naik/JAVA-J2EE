package milestone.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {

	public static void main(String[] args) {
		List<List<String>> listOfLists = Arrays.asList(Arrays.asList("first", "inside"), Arrays.asList("robert", "map"),
				Arrays.asList("fig", "whatt"));
		
		List<String> flattenedList = listOfLists.stream()
                .flatMap(List::stream) // Flatten the nested lists
                .collect(Collectors.toList()); // Collect to a new list
		
		System.out.println("Original list is: " + listOfLists);
		System.out.println("Flat list is: " + flattenedList);
	}

}

package milestone.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateNumbers {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 2, 4, 5, 6, 7, 7, 6, 10);
		Set<Integer> duplicateNumbers = numbers.stream().filter(x -> Collections.frequency(numbers, x) > 1)
				.collect(Collectors.toSet());
		System.out.println("Duplicate numbers list: " + duplicateNumbers);
	}
}

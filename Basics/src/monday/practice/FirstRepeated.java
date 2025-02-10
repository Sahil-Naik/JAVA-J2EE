package monday.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FirstRepeated {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2, 8, 7, 4, 1);

		// Finding the second-highest number using Stream API
		Optional<Integer> firstHighest = numbers.stream().distinct().sorted((a, b) -> b - a).findFirst();
		
		System.out.println("Second highest number is: " + firstHighest);
	}	

}

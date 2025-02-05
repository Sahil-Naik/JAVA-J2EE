package milestone.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConditionalPrint {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 22, -3, 34, 5, 6, 17, 8, 91, 10);
        List<Integer> satisfiedNumbers = numbers.stream().filter(x -> x > 10).collect(Collectors.toList());
        
        System.out.println("Numbers greater than 10 are: " + satisfiedNumbers);
	}
}

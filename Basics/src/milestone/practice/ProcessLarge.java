package milestone.practice;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.LongStream;

public class ProcessLarge {
	public static void main(String[] args) {
        // Generate a large list of numbers
        List<Long> numbers = new ArrayList<>();
        for (long i = 1; i <= 9000000; i++) {
            numbers.add(i);
        }

        // Measure execution time
        long startTime = System.currentTimeMillis();

        // Use parallel stream to sum all values
        long sum = numbers.parallelStream()
                          .mapToLong(Long::longValue) // Convert Long to long
                          .sum();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime; // Calculate execution time in milliseconds

        // Output the result
        System.out.println("The sum of the numbers is: " + sum);
        System.out.println("Execution time: " + executionTime + " milliseconds");
    }
}

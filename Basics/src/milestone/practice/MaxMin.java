package milestone.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class MaxMin {

	public static void main(String[] args) {
		int[] baseNumber = {3, 5, 7, 2, 8, -1, 4, 10, 12};

		int max = Arrays.stream(baseNumber).max().orElseThrow(() -> new RuntimeException("Array is empty"));
		int min = Arrays.stream(baseNumber).min().orElseThrow(() -> new RuntimeException("Array is empty"));
		
		System.out.println("Max is: " + max);
		System.out.println("Min is: " + min);
	}

}

package wipro.day8.OOPtest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import classes.OperationsOnArray;

public class OperationOnArrayTest {
	private OperationsOnArray optArray;

	@BeforeEach
	void Setup() {
		optArray = new OperationsOnArray();
	}

	@ParameterizedTest
	@CsvSource({ "'1,2,3',6", "'1,2,3,4',10", "'1,1',2" })
	void testArraySum(String input, int expected) {
		// Convert the CSV input into an ArrayList<Integer>
		ArrayList<Integer> arr = new ArrayList<>();
		for (String num : input.split(",")) {
			arr.add(Integer.parseInt(num.trim()));
		}

		// Act
		int result = optArray.ArraySum(arr);

		// Assert
		assertEquals(expected, result);
	}

	@ParameterizedTest
	@CsvSource({ "'1,2,3',2.0", "'1,2,3,4',2.50", "'1,1',1" })
	void testArrayAverage(String input, float expected) {
		// Convert the CSV input into an ArrayList<Integer>
		ArrayList<Integer> arr = new ArrayList<>();
		for (String num : input.split(",")) {
			arr.add(Integer.parseInt(num.trim()));
		}

		// Act
		float result = optArray.ArrayAverage(arr);

		// Assert
		assertEquals(expected, result, 0.001);
	}

	@AfterEach
	void breakdown() {
		optArray = null;
	}
}

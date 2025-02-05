package milestone.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquaringNumber {

	public static void main(String[] args) {
		ArrayList<Integer> baseNumber = new ArrayList<Integer>();
		baseNumber.add(2);
		baseNumber.add(3);
		baseNumber.add(4);
		
		ArrayList<Integer> squareNumber = (ArrayList<Integer>) baseNumber.stream().map(x -> x*x).collect(Collectors.toList());		
		System.out.println("Squared: " + squareNumber);
	}

}

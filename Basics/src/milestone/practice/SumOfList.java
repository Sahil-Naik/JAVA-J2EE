package milestone.practice;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SumOfList {
	
	public static void main(String[] args) {
		ArrayList<Integer> baseNumber = new ArrayList<Integer>();
		baseNumber.add(2);
		baseNumber.add(3);
		baseNumber.add(4);
		
		int sum =  baseNumber.stream().reduce(0, Integer::sum);	
		System.out.println("Sum is: " + sum);
	}

}

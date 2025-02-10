package monday.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class DuplicateInArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> myArr = new ArrayList<Integer>();
		
		myArr.add(1);
		myArr.add(2);
		myArr.add(3);
		myArr.add(3);
		myArr.add(4);
		myArr.add(5);
		
		System.out.printf("Duplicate elements are: ");
		System.out.println(myArr.stream().filter(x -> Collections.frequency(myArr, x)>1).collect(Collectors.toSet()));
	}

}

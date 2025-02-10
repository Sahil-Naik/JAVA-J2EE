package monday.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class SingleCountElement {
	
	public static void main(String[] args) {
		ArrayList<Integer> myArr = new ArrayList<Integer>();
		
		myArr.add(1);
		myArr.add(1);
		myArr.add(3);
		myArr.add(3);
		myArr.add(5);
		myArr.add(4);
		myArr.add(4);
		
		System.out.printf("Single Count elements are: ");
		System.out.println(myArr.stream().filter(x -> Collections.frequency(myArr, x)<2).collect(Collectors.toSet()));
	}

}

package monday.practice;

import java.util.ArrayList;
import java.util.Collections;

public class SecondLargestNumber {
	
	public static void main(String[] args) {
		ArrayList<Integer> myArr = new ArrayList<Integer>();
		
		myArr.add(50);
		myArr.add(71);
		myArr.add(45);
		myArr.add(33);
		myArr.add(21);
		myArr.add(7);
		
		Collections.sort(myArr);
		
		System.out.println("Second largest number is: "+myArr.get(myArr.size()-2));
	}

}

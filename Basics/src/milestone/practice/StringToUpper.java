package milestone.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToUpper {
	
	public static void main(String[] args) {
		ArrayList<String> stringArr = new ArrayList<String>();
		stringArr.add("test");
		stringArr.add("lower");
		stringArr.add("nEAt");
		
		System.out.println("Upper: " + stringArr.stream().map(x -> x.toUpperCase()).collect(Collectors.toList()));
	}

}

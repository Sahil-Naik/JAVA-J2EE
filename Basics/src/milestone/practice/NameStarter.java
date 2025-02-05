package milestone.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameStarter {
	
	public static void main(String[] args) {
		ArrayList<String> stringArr = new ArrayList<String>();
		stringArr.add("ArrivAL");
		stringArr.add("lower");
		stringArr.add("arcade");
		
		System.out.println("Starts with A: " + stringArr.stream().map(x -> x.toUpperCase()).filter(x -> x.startsWith("A")).collect(Collectors.toList()));
	}

}

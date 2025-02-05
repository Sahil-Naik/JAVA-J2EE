package milestone.practice;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SortStringList {

	public static void main(String[] args) {
		ArrayList<String> stringArr = new ArrayList<String>();
		stringArr.add("ArrivAL");
		stringArr.add("lower");
		stringArr.add("arcade");

		System.out.println("Starts with A: " + stringArr.stream().map(x -> x.toUpperCase()).sorted().collect(Collectors.toList()));
	}

}

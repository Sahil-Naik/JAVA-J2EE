package wipro.day6.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StringStream {
	public static void main(String[] args) {
		List<String> myString = Arrays.asList("Elden Ring", "Dark SOULS", "overWatch", "Cs2");
		
		System.out.println("My list is: "+myString);
		
		
		List<String> myStringU = myString.stream().map(x -> x.toUpperCase()).
				collect(Collectors.toList());
		System.out.println("\nConverting all elements to Upper: "+"\n"+myStringU);
		
		List<String> myStringL = myString.stream().map(x -> x.toLowerCase()).
				collect(Collectors.toList());
		System.out.println("\nConverting all elements to Lower: "+"\n"+myStringL);
		
		System.out.printf("\nFirst 3 are: \n");
		myStringU.stream().limit(3).forEach(x -> System.out.println(x));
		
		System.out.printf("\nAfter first 3 are: \n");
		myStringU.stream().skip(3).forEach(x -> System.out.println(x));
	}

}

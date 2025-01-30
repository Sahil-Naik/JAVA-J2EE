package wipro.day6.stream;

import java.util.*;

public class NumberStream {
	
	public static void main(String[] args) {
		
		List<Integer> myNumbers = Arrays.asList(25,36,78,71,45,7,52,10);
		System.out.println("My list is: " + myNumbers);
		
		System.out.println("\nAscending order: ");
		myNumbers.stream().sorted().forEach(x->System.out.printf(x+" "));
		
		System.out.println("\nDescending order: ");
		myNumbers.stream().sorted((x,y)->y.compareTo(x)).forEach(x->System.out.printf(x+" "));
		
		System.out.printf("\n\nTotal is: ");
		int sum = myNumbers.stream().reduce(0, (x,y)->x+y);
		System.out.printf(sum+"");
		
		System.out.printf("\nMaximum is: ");
		int maxNum = myNumbers.stream().reduce(Integer.MIN_VALUE, (x,y)->Integer.max(x, y));
		System.out.printf(maxNum+"");
		
		System.out.printf("\nMinimum is: ");
		int minNum = myNumbers.stream().reduce(Integer.MAX_VALUE, (x,y)->Integer.min(x, y));
		System.out.printf(minNum+"");
		
		System.out.printf("\n\nFirst 3 are: ");
		myNumbers.stream().limit(3).forEach(x -> System.out.printf(x+" "));
		
		System.out.printf("\nSkipping first 3 we have: ");
		myNumbers.stream().skip(3).forEach(x -> System.out.printf(x+" "));
		
		System.out.printf("\n\nEven numbers are: ");
		myNumbers.stream().filter(x -> x%2==0).forEach(x -> System.out.printf(x+" "));
		
		System.out.printf("\nOdd numbers are: ");
		myNumbers.stream().filter(x -> x%2!=0).forEach(x -> System.out.printf(x+" "));
		
		System.out.printf("\nDivisible by 5 are: ");
		myNumbers.stream().filter(x -> x%5==0).forEach(x -> System.out.printf(x+" "));
		
		System.out.printf("\n\nDivisible by 5 and Even are: ");
		myNumbers.stream().filter(x -> x%5==0 && x%2==0).findAny().
		ifPresentOrElse(x->myNumbers.stream().filter(y -> y%5==0 && y%2==0).forEach(y->System.out.printf(y+" ")),
				()-> System.out.printf("None"));
		
		System.out.printf("\nDivisible by 5 and Odd are: ");
		myNumbers.stream().filter(x -> x%5==0 && x%2!=0).findAny().
		ifPresentOrElse(x->myNumbers.stream().filter(y -> y%5==0 && y%2!=0).forEach(y->System.out.printf(y+" ")),
				()-> System.out.printf("None"));
	}

}

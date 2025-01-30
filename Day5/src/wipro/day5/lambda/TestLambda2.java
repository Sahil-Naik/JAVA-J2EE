package wipro.day5.lambda;

import java.util.ArrayList;

public class TestLambda2 {
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(52);
		arr.add(2);
		arr.add(12);
		arr.add(27);
		arr.add(59);
		arr.add(62);
		arr.add(22);
		
		arr.forEach(n -> System.out.println(n));
	}

}

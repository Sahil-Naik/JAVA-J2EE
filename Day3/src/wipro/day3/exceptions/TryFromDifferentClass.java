package wipro.day3.exceptions;

public class TryFromDifferentClass {
	
	public static void main(String[] args) {
		FaultyMethod obj = new FaultyMethod();
		
		try {
			obj.operation();
		}
		catch (ArithmeticException ae) {
			System.out.println("\nDenominator cannot be Zero!");
		}
		
	}

}

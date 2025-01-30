package wipro.day3.exceptions;

public class FaultyMethod {
	
	public void operation() throws ArithmeticException {
		int x = 10;
		int y = 0;
		
		int divi = x / y;
		System.out.println("Division is: " + divi);
	}

}

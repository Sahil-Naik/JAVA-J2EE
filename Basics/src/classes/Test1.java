package classes;
import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) {
		CustomMethods operation = new CustomMethods();
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		int userNumber1 = obj.nextInt();
		
		System.out.println("Enter second number:");
		int userNumber2 = obj.nextInt();
		
		try {
			int addition = operation.addition(userNumber1, userNumber2);
			int subtraction = operation.subtraction(userNumber1, userNumber2);
			int multiplication = operation.multiplication(userNumber1, userNumber2);
			double division = operation.division(userNumber1, userNumber2);
			int remainder = operation.remainder(userNumber1, userNumber2);
			
			System.out.println("\nAddition is: "+addition);
			System.out.println("Subtraction is: "+subtraction);
			System.out.println("Multiplication is: "+multiplication);
			System.out.println("Division is: "+division);
			System.out.println("Remainder is: "+remainder);
		}
		catch (ArithmeticException ae) {
			System.out.println("\nDenomiator cannot be Zero!");
		}
		finally {
			System.out.println("\nEnd of Exceptions");
		}
		
		System.out.println("\nEnd of Main method.");
		
		obj.close();
		
	}

}

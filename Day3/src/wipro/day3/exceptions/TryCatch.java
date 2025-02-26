package wipro.day3.exceptions;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
	
	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);		
		
		try {
			System.out.println("Enter first number: ");
			int number1 = obj.nextInt();
			
			System.out.println("Enter second number: ");
			int number2 = obj.nextInt();
			
			int division = number1/number2;
			System.out.println("\nDivision is: "+division);
		}
		catch (ArithmeticException ae) {
			System.out.println("\nDivision by Zero is not possible!");
		}
		catch (InputMismatchException ime){
			System.out.println("\nDenomitor/Numerator should be number only!");
		}
		catch (RuntimeException re) {
			System.out.println("You messed up!");
		}
		finally {
			System.out.println("\nEnd of Exception Handling.\n");
		}
		
	}

}

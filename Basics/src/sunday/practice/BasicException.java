/*16. Exception Handling:
 Write code that demonstrates the use of try-catch blocks to handle exceptions.*/

package sunday.practice;

public class BasicException {
    public static void main(String[] args) {
        try {
            // ArithmeticException (Divide by Zero)
            int a = 10, b = 0;
            int result = a / b; // Throws an exception
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
        	//System.out.println(e.getMessage());
            System.out.println("Error: Cannot divide by zero!");
        }

        try {
            // ArrayIndexOutOfBoundsException
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // Accessing invalid index
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds!");
        }

        // Finally block (executes regardless of exception)
        finally {
            System.out.println("\nExecution completed.");
        }
    }
}

/*19. Lambda Expressions:
 Use lambda expressions to implement functional interfaces.*/


package sunday.practice;

interface CustomMethod {
	void multiply(int userNumber);
	
	// A non-abstract (or default) function
    default void normalFun()
    {
       System.out.println("Hello");
    }
}

public class BasicLambda {
	public static void main(String[] args) {
		CustomMethod CustomLambda = (int x) -> System.out.println("Multiply is: "+x*5);
		
		CustomLambda.multiply(5);
	}
}

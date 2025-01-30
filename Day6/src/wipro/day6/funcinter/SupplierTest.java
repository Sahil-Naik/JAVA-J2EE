package wipro.day6.funcinter;

import java.util.function.Supplier;

public class SupplierTest {
	// get()
	public static void main(String[] args) {
		String userString = "Hello";
		
		Supplier<Integer> sup = () -> userString.length();
		
		System.out.println("Length is: "+sup.get());
	}

}

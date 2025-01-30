package wipro.day6.funcinter;

public class CustomFITest {
	
	public static void main(String[] args) {
		MyFI fit = (x,y) -> x + y ;
		
		System.out.println("Addition is: "+fit.NumberSum(5,6));
	}	
	
}

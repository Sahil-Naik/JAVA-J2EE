package wipro.day3.access1;

// PROTECTED class can be accessed - Within Class, Within Same Package, Outside Package by Subclass only

public class protectedClass {
	protected void msg(){
		System.out.println("I'm from Different package's Protected Class!");
		}  
}
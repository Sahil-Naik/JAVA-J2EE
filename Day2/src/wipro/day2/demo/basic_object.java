// Object and Class

package wipro.day2.demo;

public class basic_object {
	
	int myNumber = 1;
	String myString = "YES";
	
	public static void main(String[] args) {
		System.out.println("HELLO!");
		
		basic_object obj = new basic_object();
		System.out.println("Number is: "+ obj.myNumber);
		System.out.println("String is: "+ obj.myString);
	}

}

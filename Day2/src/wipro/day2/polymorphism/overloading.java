package wipro.day2.polymorphism;

public class overloading {
	
	public void display(int a) {
		System.out.println("There is only 1 arguement: "+ a);
	}
	
	public void display(int a, int b) {
		System.out.println("There are 2 arguements: " + a + " & " + b);
	}
	
	public static void main(String[] args) {
		overloading overObj = new overloading();
		
		overObj.display(10);
		overObj.display(10,20);
		
	}

}

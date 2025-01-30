package wipro.day2.constructors;

public class construct_demo_a {
	
	construct_demo_a(){
		System.out.println("Default A Constructor");
	}
	
	construct_demo_a(int x, String y){
		int number1 = x;
		String userName1 = y;
		
		System.out.println("Parameterized A Constructor");
		System.out.println("Number: "+number1+"\nName: "+userName1);
	}

}

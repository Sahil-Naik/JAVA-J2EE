package wipro.day2.demo;

public class parameterized_constructor {
	
	String make, model;
	int costOfCar;
	
	parameterized_constructor(){
		make = "noName";
		model = "noName";
		costOfCar = 0;
	}
	
	parameterized_constructor(String x1, String x2, int y1){
		make = x1;
		model = x2;
		costOfCar = y1;
	}
	
	public static void main(String[] args) {
		System.out.println("Parameterized Constructor: ");
		parameterized_constructor paraObj = new parameterized_constructor("Lamborghini", "Egoista", 5000000);
		System.out.println("Brand is: "+ paraObj.make);
		System.out.println("Model is: "+ paraObj.model);
		System.out.println("Cost is: $" + paraObj.costOfCar);
		
		System.out.println("\nDefault Constructor: ");
		parameterized_constructor defObj = new parameterized_constructor();
		System.out.println("Brand is: "+ defObj.make);
		System.out.println("Model is: "+ defObj.model);
		System.out.println("Cost is: $" + defObj.costOfCar);
	}

}

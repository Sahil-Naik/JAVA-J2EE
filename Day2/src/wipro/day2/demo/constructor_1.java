// Default Constructor

package wipro.day2.demo;

public class constructor_1 {
	
	String make, model;
	
	constructor_1(){
		make = "BMW";
		model = "M5";
	}
	
	public static void main(String[] args) {
		constructor_1 carsObj = new constructor_1();
		System.out.println(carsObj.make);
		System.out.println(carsObj.model);
	}

}

package wipro.day2.polymorphism;

class Parent {
	public void display() {
		System.out.println("This is inside Parent class!");
	}
}

class Child extends Parent {
	
	@Override
	public void display() {
		System.out.println("This is inside Child Class!");
	}
}
public class overriding {	
	
	public static void main(String[] args) {
		Parent parObj = new Parent();
		Parent childObj = new Child();
		
		parObj.display();
		childObj.display();
		
		
	}

}

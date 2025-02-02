/*15. Inheritance and Polymorphism:
 Implement a class hierarchy with inheritance and demonstrate polymorphism.*/


package sunday.practice;

//Base class (Superclass)
class Animal {
	String name;

	Animal(String name) {
		this.name = name;
	}

	// Method to be overridden
	public void makeSound() {
		System.out.println(name + " makes a sound.");
	}
}

//Derived class (Dog)
class Dog extends Animal {
	Dog(String name) {
		super(name);
	}

	@Override
	public void makeSound() {
		System.out.println(name + " barks: Woof Woof!");
	}
}

//Derived class (Cat)
class Cat extends Animal {
	Cat(String name) {
		super(name);
	}

	@Override
	public void makeSound() {
		System.out.println(name + " meows: Meow Meow!");
	}
}

//Derived class (Cow)
class Cow extends Animal {
	Cow(String name) {
		super(name);
	}

	@Override
	public void makeSound() {
		System.out.println(name + " moos: Moo Moo!");
	}
}

//Main class
public class BasicInherit {
	public static void main(String[] args) {
		// Polymorphic behavior: Array of Animal objects
		Animal[] animals = { new Dog("Buddy"), new Cat("Whiskers"), new Cow("Daisy") };

		// Demonstrating polymorphism
		for (Animal animal : animals) {
			animal.makeSound(); // Calls overridden method
		}
	}
}

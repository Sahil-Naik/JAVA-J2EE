package wipro.day3.inter;

public class Main {
	public static void main(String[] args) {
        Cat cat = new Cat();
        
        cat.makeSound(); // From Animal interface
        cat.walk();      // From Mammal class
        cat.fetch();     // From Cat class
    }
}

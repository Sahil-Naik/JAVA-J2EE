package wipro.day3.inter;

// Here 'Cat' will become a child for parent 'Mammal'
public class Cat extends Mammal implements Animalia {
	@Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    public void fetch() {
        System.out.println("The Cat is fetching the ball.");
    }
}

package classes;
import java.util.Random;

// RULES: Take any positive number greater than 0
// IF number is 'ODD' MULTIPLY it by 3 and ADD 1
// IF number is 'EVEN' divide it by 2
// When you keep doing it for long enough you will always end up with 4->2->1

public class MathsProblem {
	
	public static void main(String[] args) {
		Random random = new Random();
		
		int rand = 0;
		
		while (rand==0) {
			rand = random.nextInt(100);
		}		
		
		System.out.println("Random number between 1 and 100 is: " + rand);
		
		System.out.println("\nThe sequence is: ");
		
		do {
			if (rand%2==0) {
				rand = rand / 2;
			} else {
				rand = rand * 3;
				rand+=1;
			}
			System.out.printf("%d ",rand);
		} while (rand!=1);
		
	}

}

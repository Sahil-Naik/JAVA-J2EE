package wipro.day6.funcinter;

import java.util.function.Predicate;
import java.util.Scanner;

// Using Lambda Expression we can duplicate Functional Interface class with new logic

public class PredicateTest {
	// boolean test(T t)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Predicate<Integer> pFunc = x -> x%5==0;
		
		System.out.printf("Enter a number: ");
		int userNumber = sc.nextInt();
		
		if (pFunc.test(userNumber)) {
			System.out.println(userNumber+" number is multiple of 5!");
		} else {
			System.out.println(userNumber+" number is not multiple of 5!");
		}
		
		sc.nextLine();
		Predicate<Integer> pFunc2 = x -> x%2==0;
		
		System.out.printf("\nEnter another number: ");
		userNumber = sc.nextInt();
		
		//System.out.println("\n"+userNumber+"\n");
		if (pFunc2.test(userNumber)) {
			System.out.println(userNumber+" number is Even!");
		} else {
			System.out.println(userNumber+" number is Odd!");
		}
		sc.close();
	}

}

/*5. Fibonacci Series:
 Generate the first n numbers in the Fibonacci sequence.*/


package sunday.practice;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        int nterms = 0; // Number of terms to display
        
        Scanner sc = new Scanner(System.in);
        
        while (nterms == 0) {
			System.out.printf("Enter n terms: ");
			nterms = sc.nextInt();
			if (nterms == 0 && nterms > -1) {
				System.out.println("n cannot be Zero!");
				System.out.println("\nRetry...");
			} else if (nterms < 0) {
				System.out.println("n cannot be Negative!");
				System.out.println("\nRetry...");
				nterms = 0;
			} else {
				break;
			}
		}
        
        
        int[] fib = new int[nterms];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < nterms; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.print("\nThe first "+nterms+" in Fibonacci Series are: ");
        for (int i = 0; i < nterms; i++) {
            System.out.print(fib[i] + (i < nterms - 1 ? ", " : ""));
        }
        
        sc.close();
    }    
}


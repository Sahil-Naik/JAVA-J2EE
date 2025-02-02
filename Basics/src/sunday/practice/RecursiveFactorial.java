/*20. Recursive Algorithms:
 Solve a problem using recursion, such as computing the factorial or Fibonacci sequence.*/

package sunday.practice;

public class RecursiveFactorial {

    // Recursive method to calculate factorial
    public static int factorial(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive case
        else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int number = 5;  // Example input
        int result = factorial(number);  // Calling the recursive factorial method
        System.out.println("Factorial of " + number + " is: " + result);
    }
}


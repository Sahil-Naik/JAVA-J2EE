/*13. Implement a Stack:
 Create a stack data structure and implement basic operations (push, pop).*/


package sunday.practice;

import java.util.Stack;

public class BasicStack {
	public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop()); // Outputs 30
        System.out.println("Popped element: " + stack.pop()); // Outputs 20

        // Peek at the top element without removing it
        System.out.println("Top element: " + stack.peek()); // Outputs 10
    }
}

package wipro.day4.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

// Remove - removes the element from Queue
// Peek - only return the element at head position of Queue

public class SimpleQueue {
	    public static void main(String[] args) {
	    	
	    	// Generic type as String
	        Queue<String> queue = new LinkedList<>();

	        // add elements to the queue
	        queue.add("Test1");
	        queue.add("Test2");
	        queue.add("Taste3");

	        // print the queue
	        System.out.println("Queue: " + queue);

	        // remove the element at the front of the queue
	        String front = queue.remove();
	        System.out.println("\nRemoved element: " + front);

	        // print the updated queue
	        System.out.println("Queue after removal: " + queue);

	        // add another element to the queue
	        queue.add("date");
	        System.out.println("\nNew Queue: " + queue);

	        // peek at the element at the front of the queue
	        String peeked = queue.peek();
	        System.out.println("\nPeeked element: " + peeked);

	        // print the updated queue
	        System.out.println("Queue after peek: " + queue);
	        
	        // print the size queue
	        System.out.println("\nQueue Size: " + queue.size());
	    }
}

package wipro.day4.ArrayList;
import java.util.PriorityQueue;

public class PriorQueue {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> PQ = new PriorityQueue<Integer>();
		
		PQ.add(10);
		PQ.add(33);
		PQ.add(45);
		
		System.out.println("Current Priority Queue is: "+ PQ);
		System.out.println("\nPeeking Head: "+ PQ.peek());
		System.out.println("Polling Element: "+ PQ.poll());
		System.out.println("\nFinal Priority Queue is: "+ PQ);
	}

}

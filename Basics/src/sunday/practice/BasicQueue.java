/*14. Implement a Queue:
 Create a queue data structure and implement basic operations (enqueue, dequeue).*/


package sunday.practice;

import java.util.Arrays;

public class BasicQueue {
	static int front = -1, rear = -1, size = 5; // Fixed-size queue
	static int[] queue = new int[size];

	// Enqueue (Insert element)
	public static void enqueue(int data) {
		if (rear == size - 1) {
			System.out.println("\nQueue is Full!");
			return;
		}
		if (front == -1)
			front = 0; // Initialize front
		queue[++rear] = data;
		System.out.println("Enqueued: " + data);
	}

	// Dequeue (Remove element)
	public static void dequeue() {
		if (front == -1 || front > rear) {
			System.out.println("Queue is Empty!");
			return;
		}
		System.out.println("\nDequeued: " + queue[front]);
		front++;
	}

	// Display Queue
	public static void display() {
		if (front == -1 || front > rear) {
			System.out.println("Queue is Empty!");
			return;
		}
		System.out.println("\nQueue: " + Arrays.toString(Arrays.copyOfRange(queue, front, rear + 1)));
	}

	public static void main(String[] args) {
		enqueue(10);
		enqueue(20);
		enqueue(30);
		enqueue(40);
		enqueue(50);
		enqueue(60); // Overflow

		display(); // Print queue

		dequeue();
		dequeue();

		display(); // Print queue after dequeuing
	}
}

/*18. Multithreading:
 Create a simple multithreaded program and demonstrate thread synchronization.*/

package sunday.practice;

class Counter {
    private int count = 0;

    // Synchronized method to ensure thread-safe access to the counter
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " Incremented: " + count);
    }

    public int getCount() {
        return count;
    }
}

class MyThread extends Thread {
    private Counter counter;

    MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
            try {
                Thread.sleep(500); // Simulate some delay
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create two threads using MyThread class
        Thread t1 = new MyThread(counter);
        Thread t2 = new MyThread(counter);

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // Final counter value
        System.out.println("\nFinal count: " + counter.getCount());
    }
}


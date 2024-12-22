package threads;
public class Counter {
    private int count = 0; // Explicit initialization

    // Synchronized increment method
    public synchronized void increment(String threadName) {
        count++;
        System.out.println(threadName + " is increasing the count to: " + count);
    }

    // Getter for the count
    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        // Creating 5 threads
        Thread t1 = new Thread(() -> counter.increment("T1"));
        Thread t2 = new Thread(() -> counter.increment("T2"));
        Thread t3 = new Thread(() -> counter.increment("T3"));
        Thread t4 = new Thread(() -> counter.increment("T4"));
        Thread t5 = new Thread(() -> counter.increment("T5"));

        // Starting all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Ensuring all threads finish execution
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            System.err.println("A thread was interrupted: " + e.getMessage());
        }

        // Displaying final count
        System.out.println("Final count: " + counter.getCount());
    }
}

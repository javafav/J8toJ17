package threads;

import java.util.concurrent.TimeUnit;

public class TwoThreadsJoin {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("First 10 dots are being printed by thread1.");
                for (int i = 0; i < 10; i++) {
                    System.out.print(" . ");
                    TimeUnit.MILLISECONDS.sleep(500); // Simulates some work
                }
                System.out.println("\nThread1 has completed.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2 is now starting after thread1.");
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread2: Performing task " + (i + 1));
                try {
                    TimeUnit.MILLISECONDS.sleep(500); // Simulates some work
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread2 has completed.");
        });

        thread1.start();
        try {
            thread1.join(); // Main thread waits for thread1 to finish
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread2.start();
        try {
            thread2.join(); // Main thread waits for thread2 to finish
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Both threads have finished their work. Main thread resumes.");
    }
}

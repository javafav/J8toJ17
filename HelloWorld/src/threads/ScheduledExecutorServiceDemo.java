package threads;

import java.util.concurrent.Executors;

import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        // Create a ScheduledExecutorService with 2 threads
        var executor = Executors.newScheduledThreadPool(2);

        // Task 1: Simulates a 7-second delay task
        Runnable r1 = () -> {
            long start = System.currentTimeMillis();
            System.out.println("R1 STARTED at: " + (start / 1000) + " seconds");
            try {
                TimeUnit.SECONDS.sleep(7); // Simulates 7 seconds of execution
            } catch (InterruptedException e) {
                System.err.println("R1 was interrupted!");
            }
            long end = System.currentTimeMillis();
            System.out.println("R1 FINISHED at: " + (end / 1000) + " seconds");
        };

        // Task 2: Simulates a 5-second delay task
        Runnable r2 = () -> {
            long start = System.currentTimeMillis();
            System.out.println("R2 STARTED at: " + (start / 1000) + " seconds");
            try {
                TimeUnit.SECONDS.sleep(5); // Simulates 5 seconds of execution
            } catch (InterruptedException e) {
                System.err.println("R2 was interrupted!");
            }
            long end = System.currentTimeMillis();
            System.out.println("R2 FINISHED at: " + (end / 1000) + " seconds");
        };

        // Schedule Task 1 using scheduleAtFixedRate (Fixed interval between start times)
        var task1 = executor.scheduleAtFixedRate(r1, 0, 3, TimeUnit.SECONDS);

        // Schedule Task 2 using scheduleWithFixedDelay (Fixed delay after each completion)
        var task2 = executor.scheduleWithFixedDelay(r2, 0, 4, TimeUnit.SECONDS);

        // Record the start time for tracking execution
        long startTime = System.currentTimeMillis();

        try {
            // Monitor task2 for 10 seconds and cancel it after that
            while (!task2.isDone()) {
                try {
                    TimeUnit.SECONDS.sleep(1); // Check every second
                    long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                    System.out.println("Elapsed time: " + elapsedTime + " seconds");

                    // Cancel task2 after 10 seconds of total runtime
                    if (elapsedTime > 10) {
                        System.out.println("Cancelling Task 2 after 10 seconds...");
                        task2.cancel(true); // Cancel the task
                        break;
                    }
                } catch (InterruptedException e) {
                    System.err.println("Main thread interrupted!");
                }
            }
        } finally {
            System.out.println("Shutting down executor...");
            executor.shutdown(); // Gracefully shutdown the executor
        }

        System.out.println("Main thread exiting.");
    }
}

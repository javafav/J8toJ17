package threads;

public class TimedJoin {
    public static void main(String[] args) {
        Thread threadFor5Seconds = new Thread(() -> {
            try {
                System.out.print("Waking up ");
                for (int i = 0; i < 5; i++) {
                    System.out.print(".");
                    Thread.sleep(1000);
                }
                System.out.println("\n I am walked!!! Hey buddy Whats up ?");

            } catch (InterruptedException e) {
                System.out.println("\nThread was interrupted before completion.");
            }
        });
        threadFor5Seconds.start();
        try {
            threadFor5Seconds.join(2000);
            if (threadFor5Seconds.isAlive()) {
                System.out.println("Waited long enough!");
                System.out.println("\nThread is too slow, interrupting it now.");
                threadFor5Seconds.interrupt();
            }

        }  catch (InterruptedException e) {
            System.out.println("Main thread was interrupted while waiting.");
        }
        System.out.println("Main function is ending now");

    }
}

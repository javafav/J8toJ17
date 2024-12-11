package threads;

import java.util.concurrent.TimeUnit;

public class RunningThread {
    public static void main(String[] args) {
        System.out.println("Main thread is running");
        try {
            System.out.println("Main thread is pausing for two seconds");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(() -> {
            String tName = Thread.currentThread().getName();
            System.out.println(tName + " should take 10 dots to run");
            for (int i = 0; i < 10; i++) {
                System.out.print(". ");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("A.State is " + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    System.out.println("\nWhoops! " + tName + " was interrupted and will stop now.");
                    return; // Exit the thread loop
                }
            }
            System.out.println(tName + " thread completed successfully");
        });

        System.out.println(thread.getName() + " starting");
        thread.start();

        long now = System.currentTimeMillis();
        while (thread.isAlive()){
            System.out.println("\nWaiting for to complete" );
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("\nB.State " + thread.getState());
                if(System.currentTimeMillis() - now > 2000){
                    thread.interrupt();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Taking too much time to download");
            }
        }

        System.out.println("C.State " + thread.getState());





//        System.out.println("Main thread is continued here");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();
    }
}

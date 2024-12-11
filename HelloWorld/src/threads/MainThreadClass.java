package threads;

import java.util.concurrent.TimeUnit;

public class MainThreadClass {
    public static void main(String[] args) {
        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());
        System.out.println(currentThread);
        printThreadState(currentThread);
        currentThread.setName("Main Guy");
        currentThread.setPriority(Thread.MAX_PRIORITY);
        printThreadState(currentThread);

        CustomThread customThread = new CustomThread();
       customThread.setPriority(10);
        customThread.start(); // we can't use run method because its run sysnconyelsy

        Runnable myRunnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.print(" 2 ");
                try {
                    //  Thread.sleep(250);
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread myThread = new Thread(myRunnable);
        myThread.start();
        for (int i = 0; i < 3; i++) {
            System.out.print(" 0 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void printThreadState(Thread thread) {
        System.out.println("-----------------------");
        System.out.println("Thread Id: " + thread.getId());
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
        System.out.println("Thread Group: " + thread.getThreadGroup());
        System.out.println("Thread State: " + thread.getState());
        System.out.println("Thread isALive: " + thread.isAlive());
        System.out.println("-----------------------");

    }
}

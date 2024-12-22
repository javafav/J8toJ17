package threads;

public class PrintingNumbersWithSynchronization {
    private int number = 1;
    private Object printLock = new Object();

    public void printNumber(String threadName) {
        for(int i =0;i<20; i++){
            synchronized (printLock) {


                if (number <= 20){
                    System.out.println(threadName + " Printing: " + number);
                    number++;
                }else {
                    System.out.println("Number is exceeded to 20");
                    System.exit(0);
                }

            }

        }

    }

    public static void main(String[] args) {
        PrintingNumbersWithSynchronization counter = new PrintingNumbersWithSynchronization();

        // Creating 5 threads
        Thread t1 = new Thread(() -> counter.printNumber("T1"));
        Thread t2 = new Thread(() -> counter.printNumber("T2"));
        Thread t3 = new Thread(() -> counter.printNumber("T3"));
        Thread t4 = new Thread(() -> counter.printNumber("T4"));

        // Starting all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();


        // Ensuring all threads finish execution
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        } catch (InterruptedException e) {
            System.err.println("A thread was interrupted: " + e.getMessage());
        }


    }

}


/*
Write a program where multiple threads try to print numbers from 1 to 20 in sequence.
The program ensures that no two threads print the same number at the same time.

Use a shared Object lock to synchronize the printing.
Each thread should acquire the lock before printing and release it after printing.
 */
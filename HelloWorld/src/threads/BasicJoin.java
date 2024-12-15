package threads;

import java.util.concurrent.TimeUnit;

public class BasicJoin {
    public static void main(String[] args) {
        Thread printingNumber = new Thread( () -> {
            for(int i = 0; i< 10; i++){
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                System.out.print(i + " ");
            }
        }, "PrintingThread");


        printingNumber.start();

        System.out.println("Main thread waiting for PrintingThread.");
        try {
            printingNumber.join(); // Main thread waits for t1 to finish
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nMain thread resumes after PrintingThread.");
    }

}

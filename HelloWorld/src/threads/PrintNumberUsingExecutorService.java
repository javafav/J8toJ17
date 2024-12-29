package threads;

import java.util.concurrent.Executors;

public class PrintNumberUsingExecutorService {
    public static void main(String[] args) {
        var executorService = Executors.newFixedThreadPool(3);
        executorService.execute( () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Num: " + i);
            }
        });
        executorService.shutdown();
    }
}

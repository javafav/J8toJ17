package networking;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncDiscountExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Task 1: Get the original price after 1 second
        CompletableFuture<Double> originalPriceTask = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // Simulate delay of 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100.0; // Original price
        });

        // Task 2: Apply the discount to the price
        CompletableFuture<Double> discountedPriceTask = originalPriceTask.thenApplyAsync(originalPrice -> {
            return originalPrice * 0.9; // Apply 10% discount
        });

        // Wait for both tasks to complete and get the results
        Double originalPrice = originalPriceTask.get();
        Double discountedPrice = discountedPriceTask.get();

        // Print the results
        System.out.println("Original Price: " + originalPrice);
        System.out.println("Discounted Price: " + discountedPrice);
    }
}
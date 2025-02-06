package networking;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<String> name = queryDemoDB("Ali");
        System.out.println("Fetching user data...");

        System.out.println(name.join());
    }
    private static CompletableFuture<String> queryDemoDB(String userName){
        return CompletableFuture.supplyAsync(() -> {
           try{
               Thread.sleep(2000);

           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           return "John Doe";
        });
    }
}

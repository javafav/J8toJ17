package threads;

import java.util.Random;
import java.util.concurrent.Executors;

public class ExecutorServiceChallenge {
    private static final Random random = new Random();

    public static void main(String[] args) {
        ShoeWarehouse warehouse = new ShoeWarehouse();
         var multiExecutive = Executors.newSingleThreadExecutor();
        try{
            for (int i = 0; i <15 ; i++) {
                multiExecutive.execute(() -> {
                    warehouse.receiveOrder(new Order(random.nextInt(1000000, 9999999),
                            ShoeWarehouse.PRODUCT_LIST[random.nextInt(0, 5)],
                            random.nextInt(1, 4)));
                });

                multiExecutive.execute(()-> {
                    warehouse.fullfillOrder();
                });
            }
        }finally {
            multiExecutive.shutdown();
        }


//        Thread producerThread = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                warehouse.receiveOrder(new Order(random.nextInt(1000000, 9999999),
//                        ShoeWarehouse.PRODUCT_LIST[random.nextInt(0, 5)],
//                        random.nextInt(1, 4)));
//
//            }
//        });
//        producerThread.start();
//
//        for (int i = 0; i < 2; i++) {
//            Thread consumerThread = new Thread(() -> {
//                for (int j = 0; j < 5; j++) {
//                    Order item = warehouse.fullfillOrder();
//
//                }
//            });
//            consumerThread.start();
//
//        }

    }

}

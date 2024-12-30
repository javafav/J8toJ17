package threads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class SubmitMultipleTask {
    public static void main(String[] args) {
       var multipleExecutive = Executors.newCachedThreadPool();
        try{
        for (int i = 0; i <20 ; i++) {
            final int taskNumber = i;

               if(taskNumber % 2 == 0){
                   multipleExecutive.submit( () -> System.out.println("Long time taking task is running" + taskNumber));
                   try {
                       Thread.sleep(5000);
                   } catch (InterruptedException e) {
                       System.out.println("Thread is interrupted in Long time ");
                   }
               }else {
                   multipleExecutive.submit( () -> System.out.println("Short time taking task is running" + taskNumber));
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
           }



        }finally {
            multipleExecutive.shutdown();
        }
        System.out.println("All task completed");
    }

}

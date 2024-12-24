package threads;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

public class WaitAndNotifyMethodDemo {
    private List<Integer> buffer = new ArrayList<>();
    private final int LIMIT = 5;
    public synchronized void producer(int value){
        while (buffer.size() == LIMIT){
            try {
                wait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        buffer.add(value);
        System.out.println("Produced: " + value);
        notify();

    }

    public synchronized void consumer(){
        while (buffer.isEmpty()){
            try {
                wait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        Integer value = buffer.remove(0);
        System.out.println("Consumed: " + value);
    }

    public static void main(String[] args) {
        WaitAndNotifyMethodDemo demo = new WaitAndNotifyMethodDemo();
       Thread t1 = new Thread(() -> {
          for(int i =0; i<10;i++){
              demo.producer(i);
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
       });

        Thread t2 = new Thread(() -> {
            for(int i =0; i<10;i++){
                demo.consumer();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Producer and Consumer and wait method are demonstrated");
    }


}

package threads;

public class CustomThread extends Thread{

    @Override
    public void run() {
       for(int i =0; i<5; i++){
           System.out.print(" 1 ");
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
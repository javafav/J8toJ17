package hackerrank;

public class MultiThreading extends Thread {
    private String name;

    public MultiThreading(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " is running: " + i);
        }
    }

    public static void main(String[] args) {
        MultiThreading t1 = new MultiThreading("T1");
        MultiThreading t2 = new MultiThreading("T2");
        t2.setPriority(Thread.NORM_PRIORITY);
        t1.setPriority(Thread.activeCount());

try{
    t2.start();
    t1.start();
}catch (IllegalThreadStateException ex){
    System.out.println("Exception is occurred");
}

        }

    }


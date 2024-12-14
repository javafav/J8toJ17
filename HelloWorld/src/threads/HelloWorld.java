package threads;

public class HelloWorld  extends Thread{
    @Override
    public void run() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        hello.start();
    }
}

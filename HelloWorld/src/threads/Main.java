package threads;


class PrintNumbers extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(500); // Pauses for 500ms
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PrintNumbers thread = new PrintNumbers();
        thread.start(); // Starts the new thread

        System.out.println("Main thread ends");
    }
}


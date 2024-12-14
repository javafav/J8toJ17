package threads;

public class EvenOrOddNumberThread extends Thread {
    @Override
    public void run() {
        for (int number = 1; number < 11; number++) {
            if ((number & 1) == 0) { // LSB is 0 for even numbers
                System.out.println(Thread.currentThread().getName() + " Even " + number);
            }
        }
    }

    public static void main(String[] args) {
        EvenOrOddNumberThread firstThread = new EvenOrOddNumberThread();

        Thread secondThread = new Thread(() -> {
            for (int number = 1; number < 11; number++) {
                if ((number & 1) == 1) { // LSB is 1 for odd numbers
                    System.out.println(Thread.currentThread().getName() + " Odd " + number);
                }
            }
        });

        firstThread.setName("Even Thread");
        secondThread.setName("Odd Thread");

        firstThread.start();
       secondThread.start();
    }
}

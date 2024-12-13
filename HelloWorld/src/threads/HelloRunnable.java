package threads;

class HelloRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello from a thread! Count: " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new HelloRunnable());
        thread.start();

        System.out.println("Main thread ends");
    }
}


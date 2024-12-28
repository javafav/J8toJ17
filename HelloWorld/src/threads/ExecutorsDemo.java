package threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;

class ColorThreadFactory implements ThreadFactory {
    private String threadName;

    public ColorThreadFactory(ThreadColor color) {
        this.threadName = color.name();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(threadName);
        return thread;
    }
}

public class ExecutorsDemo {
    public static void main(String[] args) {
        var blueExecutor = Executors.newSingleThreadExecutor(
                new ColorThreadFactory(ThreadColor.ANSI_BLUE)
        );
        blueExecutor.execute(ExecutorsDemo::countDown);
        blueExecutor.shutdown();

        boolean isDone = false;
        try {
           isDone =  blueExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(isDone){
            System.out.println("Blue finished, starting Yellow");
            var yellowExecutor = Executors.newSingleThreadExecutor(
                    new ColorThreadFactory(ThreadColor.ANSI_YELLOW)
            );
            yellowExecutor.execute(ExecutorsDemo::countDown);
            yellowExecutor.shutdown();
            try {
                isDone = yellowExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(isDone){
                System.out.println("Yellow finished, starting Red");
                var redExecutor = Executors.newSingleThreadExecutor(
                        new ColorThreadFactory(ThreadColor.ANSI_RED)
                );
                redExecutor.execute(ExecutorsDemo::countDown);
                redExecutor.shutdown();
                try {
                  isDone =   redExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(isDone){
                    System.out.println("All process completed");
                }
            }


        }


    }

    public static void notmain(String[] args) {
        Thread blue = new Thread(
                ExecutorsDemo::countDown, ThreadColor.ANSI_BLUE.name());

        Thread yellow = new Thread(
                ExecutorsDemo::countDown, ThreadColor.ANSI_YELLOW.name());
        Thread red = new Thread(
                ExecutorsDemo::countDown, ThreadColor.ANSI_RED.name());

        blue.start();
        try {
            blue.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        yellow.start();

        try {
            yellow.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        red.start();


        try {
            red.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void countDown() {
        String threadName = Thread.currentThread().getName();
        var threadColor = ThreadColor.ANSI_RESET;
        try {
            threadColor = ThreadColor.valueOf(threadName.toUpperCase());
        } catch (IllegalArgumentException e) {
            // e.printStackTrace();
        }
        String color = threadColor.color().toUpperCase();
        for (int i = 20; i > 0; i--) {
            System.out.println(color + " " +
                    threadName.replace("ANSI_", "") + " " + i);

        }

    }
}

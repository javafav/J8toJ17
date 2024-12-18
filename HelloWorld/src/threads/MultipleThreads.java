package threads;

import java.util.concurrent.TimeUnit;

public class MultipleThreads {
    public static void main(String[] args) {
        StopWatch greenstopWatch = new StopWatch(TimeUnit.SECONDS);
        StopWatch redstopWatch = new StopWatch(TimeUnit.SECONDS);
        StopWatch purplestopWatch = new StopWatch(TimeUnit.SECONDS);
        Thread green = new Thread(greenstopWatch::countDown, ThreadColor.ANSI_YELLOW.name());  // here the countDown method reference is target for run function
        //  Thread green = new Thread( () -> stopWatch.countDown(), ThreadColor.ANSI_YELLOW.name());
        Thread purple = new Thread(() -> purplestopWatch.countDown(7),
                ThreadColor.ANSI_PURPLE.name());
        Thread red = new Thread(redstopWatch::countDown, ThreadColor.ANSI_RED.name());  // here the countDown method reference is target for run function


        green.start();
        purple.start();


        red.start();


    }
}

class StopWatch {
    private TimeUnit timeUnit;
    private int i;

    public StopWatch(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void countDown() {
        countDown(5);
    }

    public void countDown(int unitCount) {
        String threadName = Thread.currentThread().getName();
        ThreadColor threadColor = ThreadColor.ANSI_RESET;
        try {
            threadColor = ThreadColor.valueOf(threadName);
        } catch (IllegalArgumentException e) {
            System.out.println("Bad Color Name!!!");
        }
        String color = threadColor.color();
        for (i = unitCount; i > 0; i--) {
            try {
                timeUnit.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s%s Thread : i = %d%n", color, threadName, i);
        }
    }
}
package oop.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

record Person(String firstName, String lastName, int age) {

    private final static String[] firsts =
            {"Able", "Bob", "Charlie", "Donna", "Eve", "Fred"};
    private final static String[] lasts =
            {"Norton", "OHara", "Petersen", "Quincy", "Richardson", "Smith"};

    private final static Random random = new Random();

    public Person() {
        this(firsts[random.nextInt(firsts.length)],
                lasts[random.nextInt(lasts.length)],
                random.nextInt(18, 100));
    }

    @Override
    public String toString() {
        return "%s, %s (%d)".formatted(lastName, firstName, age);
    }
}
public class VisitorList {

    private static final CopyOnWriteArrayList<Person> masterList;
    static {
        masterList = Stream.generate(Person::new)
                .distinct()
                .limit(2500)
                .collect(CopyOnWriteArrayList::new,
                        CopyOnWriteArrayList::add,
                        CopyOnWriteArrayList::addAll);
    }


    private static final   ArrayBlockingQueue<Person> newVisitors =
            new ArrayBlockingQueue<Person>(5);

    public static void main(String[] args) {
        Runnable producers = ()-> {
            Person  visitor = new Person();
            System.out.println("Queueing " + visitor);
            boolean queued = false;
          try{
              queued = newVisitors.offer(visitor, 5 , TimeUnit.SECONDS);
          }catch (InterruptedException e){
              System.out.println("Interrupted Exception");
          }

            if(queued){
             //   System.out.println(newVisitors);
            }else {
                System.out.println("Queue is Full, cannot add " + visitor);
                System.out.println("Draining Queue and writing data to file");
                List<Person> tempList = new ArrayList<>();
                newVisitors.drainTo(tempList);
                List<String> lines = new ArrayList<>();
                tempList.forEach((customer) -> lines.add(customer.toString() ));
              //  lines.add(visitor.toString());
                try{
                    Files.write(Path.of("DrainedQueue.txt"), lines,
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };


        Runnable consumer = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Polling queue " + newVisitors.size());
            Person visitor = newVisitors.poll();
            if(visitor != null){
                if(!masterList.contains(visitor)){
                    masterList.add(visitor);
                    System.out.println("---> New Visitor gets Coupon!: " + visitor);
                }

            }
            System.out.println(threadName + " done " + visitor);
        };


        ScheduledExecutorService producerExecutor = Executors.newSingleThreadScheduledExecutor();
        producerExecutor.scheduleWithFixedDelay(producers, 0,1, TimeUnit.SECONDS);


        ScheduledExecutorService consumerPoll = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 3; i++) {
consumerPoll.scheduleAtFixedRate(consumer, 6,3,TimeUnit.SECONDS);
        }

        while (true){
            try{
                if(!producerExecutor.awaitTermination(10, TimeUnit.SECONDS)){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        producerExecutor.shutdown();

        while (true){
            try{
                if(!consumerPoll.awaitTermination(3, TimeUnit.SECONDS)){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        consumerPoll.shutdown();
    }
}

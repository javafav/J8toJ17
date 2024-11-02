package oop.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamTerminal {
    public static void main(String[] args) {
        var result = IntStream
                .iterate(0, i -> i <= 1000, i -> i = i + 3)
                .summaryStatistics();

        System.out.println("Result " + result);

        var leapYear = IntStream
                .iterate(2000, i -> i <= 2025, i -> i + 1)
                .filter(i -> i% 4 == 0)
                .peek(System.out::println)
                .summaryStatistics();
        System.out.println("Leap Year " + leapYear);


        TheatreSeat[] seats = new TheatreSeat[100];
        Arrays.setAll(seats, i -> new TheatreSeat((char) ('A' + i / 10 ), i % 10 + 1 ));
        Arrays.asList(seats).forEach(System.out::println);

        long reservedSeats = Arrays.stream(seats).filter(TheatreSeat::isReserved).count();
        System.out.println("Reserved Seats " + reservedSeats);

        boolean hasBooking = Arrays.stream(seats).anyMatch(TheatreSeat::isReserved);
        System.out.println("hasBooking "+ hasBooking  );

        boolean fullyBooked = Arrays.stream(seats).allMatch(TheatreSeat::isReserved);
        System.out.println("fullyBooked "+ fullyBooked  );

        TheatreSeat isBooked = new TheatreSeat('A', 10);
        boolean b = Arrays.stream(seats).anyMatch(i -> isBooked.isReserved());
        System.out.println("Booking Confirmation " +  b);
    }
}

package hackerrank;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Calendar;

public class FIndDayInDate {
    public static void main(String[] args) {
        String day = findDay(8, 14, 2017);
        System.out.println(day);
    }
    public static String findDay(int month, int day, int year) {
        LocalDate date = LocalDate.of(year, month, day);


        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek.toString();



    }
}

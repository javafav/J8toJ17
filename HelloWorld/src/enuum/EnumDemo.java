package enuum;

import java.util.Random;

public class EnumDemo {
    public static void main(String[] args) {
        DayOfTheWeek weekDay = DayOfTheWeek.SAT;
        System.out.println(weekDay);
        for (int i = 0; i < 10; i++) {
            weekDay = getRandomDay();
//            System.out.printf("Name is %s, Ordinal Value = %d%n", weekDay.name(), weekDay.ordinal());
//
//            if(weekDay == DayOfTheWeek.SUN){
//                System.out.println("Hurrah!!! HOLIDAY!!!!!");
//            }
            printDayOfWeek(weekDay);

        }
    }

    public static DayOfTheWeek getRandomDay() {
        int randomInteger = new Random().nextInt(7);
        DayOfTheWeek[] allDays = DayOfTheWeek.values();
        //System.out.println(allDays);
        return allDays[randomInteger];
    }

    public static void printDayOfWeek(DayOfTheWeek dayWeek) {
        int weekOfDayInteger = dayWeek.ordinal() + 1;

        switch (dayWeek) {
            case SAT -> System.out.println("Saturday is Day " + weekOfDayInteger);
            case WED -> System.out.println("Wednesday is Day " + weekOfDayInteger);
            default -> System.out.println(dayWeek.name().charAt(0) +
                    dayWeek.name().substring(1).toLowerCase() +
                    "day is Day " + weekOfDayInteger);
        }
    }
}

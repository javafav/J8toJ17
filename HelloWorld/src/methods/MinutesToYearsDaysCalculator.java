package methods;

public class MinutesToYearsDaysCalculator {

    public static void main(String[] args) {
        printYearsAndDays(525600);

        printYearsAndDays(1051200);

        printYearsAndDays(561600);


    }

    //               45 min = 00 y and 30 d
    //  print format "XX min = YY y and ZZ d".
    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
            return ;
        }

        long hours = minutes / 60;
        long days = hours / 24;
        long years = days / 365;
        long remainingDays = days % 365;


        System.out.println(minutes + " min = " + years + " y and " + remainingDays + " d");
    }
}

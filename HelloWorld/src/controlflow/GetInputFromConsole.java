package controlflow;

import java.util.Scanner;

public class GetInputFromConsole {
    public static void main(String[] args) {
        int currentYear = 2024;
        try {
            System.out.println(getInputFromConsole(currentYear));
        } catch (NullPointerException ex) {
            System.out.println(getInputFromScanner(currentYear));
        }

    }

    private static String getInputFromScanner(int currentYear) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi , What is Your Name  ");

        String name = scanner.nextLine();
        int age = 0;

        System.out.println("Welcome " + name + " to Java ");

        boolean validDOB = false;
        do {
            System.out.println("Enter your year of birth >= " + (currentYear - 125) + " or <= " + currentYear);
          try{
              age = validateAge(currentYear, scanner.nextLine());
              validDOB = age < 0 ? false : true;
          } catch (NumberFormatException ex){
              System.out.println("Characters are not allowed!!! Try again.");
          }

        } while (!validDOB);


        return "Your Age is " + age;
    }

    public static String getInputFromConsole(int currentYear) {

        String name = System.console().readLine("Hi , What is Your Name ");

        System.out.println("Welcome " + name + " to Java ");


        String dateOfBirth = System.console().readLine("What year you were born?");
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "Your Age is " + age;
    }


    public static int validateAge(int currentYear, String dateOfBirth) {
        int dob = Integer.parseInt(dateOfBirth);

        int minimumYear = currentYear - 125;

        if (dob < minimumYear || dob > currentYear) {
            return -1;
        }

        return currentYear - dob;


    }
}

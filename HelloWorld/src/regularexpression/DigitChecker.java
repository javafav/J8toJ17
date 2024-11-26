package regularexpression;

import java.util.Scanner;

public class DigitChecker {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it contains only digits:");
        String input = scanner.nextLine();

        // Regular expression to match only digits
        String digitRegex = "\\d+";

        // Check if the input matches the regex
        if (input.matches(digitRegex)) {
            System.out.println("The string \"" + input + "\" contains only digits.");
        } else {
            System.out.println("The string \"" + input + "\" does not contain only digits.");
        }

        // Close the scanner
        scanner.close();
    }
}

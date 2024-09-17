package controlflow;

import java.util.Scanner;

public class MinAndMaxChallenge {
    public static void main(String[] args) {
        minAndMax();
    }

    public static void minAndMax() {
        Scanner scanner = new Scanner(System.in);
        double min = 0, max = 0;
        int loopCount = 0;

        do {
            System.out.println("Enter a number , or any character to exit");
            String numberString = scanner.nextLine();
            try {
                double validNumber = Double.parseDouble(numberString);

                if (loopCount == 0 || validNumber < min) {
                    min = validNumber;
                }

                if (loopCount == 0 || validNumber > max) {
                    max = validNumber;
                }

                loopCount++;

            } catch (NumberFormatException nfe) {
                break;
            }

        } while (true);

        if (loopCount > 0) {

            System.out.println("Min number you typed is " + min);
            System.out.println("Max number you typed is " + max);
        } else {
            System.out.println("No valid data entered");
        }


    }

}

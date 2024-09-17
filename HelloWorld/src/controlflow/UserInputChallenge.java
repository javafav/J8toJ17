package controlflow;

import java.util.Scanner;

public class UserInputChallenge {
    public static void main(String[] args) {
        SumOfFiveValidInteger();
    }

    private static void SumOfFiveValidInteger() {
        Scanner scanner = new Scanner(System.in);

        int validIntegerCount = 1;
        int sumOfFiveValidNumber = 0;
        do{
            System.out.println("Please Enter #" + validIntegerCount+":");
            try{
            String number = scanner.nextLine();
            int validNumber = Integer.parseInt(number);
            sumOfFiveValidNumber += validNumber;
                validIntegerCount++;
            } catch (NumberFormatException ex){
                System.out.println("Invalid number");
            }
        }while (validIntegerCount <= 5);
        System.out.println("The sum of 5 valid number is " + sumOfFiveValidNumber);
    }
}

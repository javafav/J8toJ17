package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {
    public static void main(String[] args) {
        int number = readInteger();
        int[] userArray = readElements(number);
        System.out.println(Arrays.toString(userArray));

    }

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers you want to enter ?");
        String input = scanner.nextLine();
        String[] splits = input.split(" ");
        return Integer.parseInt(splits[0].trim());

    }

    private static int[] readElements1(int count) {

        Scanner scanner = new Scanner(System.in);
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
            array[i] = number;
        }
        return array;
    }

    private static int[] readElements(int arrayLength) {

        int[] intArray = new int[arrayLength];
        int counter = 0;
        do {
            System.out.println("Please Enter the number");
            Scanner scanner = new Scanner(System.in);
            intArray[counter] =  scanner.nextInt();
            counter++;
            arrayLength--;
        } while (arrayLength != 0);
        return intArray;
    }
}

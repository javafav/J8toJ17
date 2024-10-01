package collections;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayListChallenge {
    public static void main(String[] args) {
        getInput();
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> groceryList = new ArrayList<>();
        int userAction = -1; // Start with a value that will not trigger shutdown immediately

        while (userAction != 0) {
            // Display the menu
            System.out.println("""
                    Available actions:\s
                     0 - to shutdown\s
                     1 - to add item(s) to the list (comma delimited list)\s
                     2 - to remove any item(s) from the list (comma delimited list)\s
                     3 - to print item(s) list\s
                     Enter a number for the action you want to do:""");

            try {
                // Get user action
                userAction = scanner.nextInt();
                scanner.nextLine();  // Consume newline character after nextInt()

                switch (userAction) {
                    case 0 -> System.out.println("Shutting down...");
                    case 1 -> {
                        System.out.println("Please enter the grocery item(s), comma-separated:");
                        String items = scanner.nextLine();
                        String[] groceryItems = items.split(",");
                        for (String item : groceryItems) {
                            item = item.trim(); // Clean up spaces
                            if (!groceryList.contains(item)) {
                                groceryList.add(item);
                                System.out.println(item + " has been added to the list.");
                            } else {
                                System.out.println(item + " is already in the list.");
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("Please enter the grocery item(s) to remove, comma-separated:");
                        String items = scanner.nextLine();
                        String[] groceryItems = items.split(",");
                        for (String item : groceryItems) {
                            item = item.trim(); // Clean up spaces
                            if (groceryList.contains(item)) {
                                groceryList.remove(item);
                                System.out.println(item + " has been removed from the list.");
                            } else {
                                System.out.println(item + " was not found in the list.");
                            }
                        }
                    }
                    case 3 -> {
                        if (groceryList.isEmpty()) {
                            System.out.println("The grocery list is empty.");
                        } else {
                            System.out.println("Items in your list: " + groceryList);
                        }
                    }
                    default -> System.out.println("Invalid choice. Please enter a valid number.");
                }
            } catch (InputMismatchException ex) {
                // Handle invalid input and prompt user again
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();  // Clear the invalid input from the scanner buffer
            }
        }
    }
}

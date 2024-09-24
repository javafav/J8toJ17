package oop.encapsulation;

public class PrinterTest {
    public static void main(String[] args) {
        Printer printer = new Printer(50, true);
        System.out.println("Initial page count = " + printer.getPagePrinted());

        int pagesPrinted = printer.printPages(5);
        System.out.printf("Current job pages: %d, Printer Total %d  %n", pagesPrinted, printer.getPagePrinted());

        pagesPrinted = printer.printPages(10);
        System.out.printf("Current job pages: %d, Printer Total %d  %n", pagesPrinted, printer.getPagePrinted());
    }
}

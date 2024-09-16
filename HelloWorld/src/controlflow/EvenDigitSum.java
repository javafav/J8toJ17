package controlflow;

public class EvenDigitSum {
    public static void main(String[] args) {

        System.out.println(getEvenDigitSum(1252));
    }

    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }

        int evenDigitsSum = 0;

        while (number != 0) {
            int evenNumbercheck = number % 10;

            if (evenNumbercheck % 2 == 0) {
                evenDigitsSum += evenNumbercheck;
            }
            number = number / 10;
        }
        return evenDigitsSum;
    }
}

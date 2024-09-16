package controlflow;

public class SharedDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(23, 30));
    }

    public static boolean hasSharedDigit(int number1, int number2) {
        if ((number1 < 10 || number1 > 99) || (number2 < 10 || number2 > 99)) {
            return false;
        }

        int sharedDigtit1 = 0, sharedDigtit2 = 0;


        int firstDigitOfNumber1 = number1 % 10;
        int secondDigitOfNumber1 = number1 / 10;
        int firstDigitOfNumber2 = number2 % 10;
        int secondDigitOfNumber2 = number2 / 10;

        return ((firstDigitOfNumber1 == firstDigitOfNumber2) || (secondDigitOfNumber1 == secondDigitOfNumber2) ||
                (firstDigitOfNumber1 == secondDigitOfNumber2) || (secondDigitOfNumber1 == firstDigitOfNumber2));

    }
}

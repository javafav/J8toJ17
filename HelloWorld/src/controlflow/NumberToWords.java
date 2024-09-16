package controlflow;

public class NumberToWords {
    public static void main(String[] args) {
        numberToWords(02);

    }

    public static void numberToWords(int number) {

        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }

        // get reversed number
        int reverse = reverse(number);

        // subtract numberDigits and reverseDigits to get leading zeroes
        int leadingZeroes = getDigitCount(number) - getDigitCount(reverse);




        if (number == 0) {
            System.out.println("Zero");
            return;
        }

        // use loop to print words
        while (reverse != 0) {
            int lastDigit = reverse % 10;
            switch (lastDigit) {
                case 0 -> System.out.println("Zero");
                case 1 -> System.out.println("One");
                case 2 -> System.out.println("Two");
                case 3 -> System.out.println("Three");
                case 4 -> System.out.println("Four");
                case 5 -> System.out.println("Five");
                case 6 -> System.out.println("Six");
                case 7 -> System.out.println("Seven");
                case 8 -> System.out.println("Eight");
                case 9 -> System.out.println("Nine");
            }
            reverse /= 10;
        }

        // print zeroes if there are any leading zeroes in reversed number
        for (int i = 0; i < leadingZeroes; i++) {
            System.out.println("Zero");
        }
    }
    public  static int reverse(int number){

        int reverse = 0;
        while (number != 0) {
            int firstDigit = number % 10;
            reverse = reverse * 10 + firstDigit;
            number = number / 10;


        }
        return reverse;
    }

    public  static  int getDigitCount(int number){

        if (number < 0) {
            return -1;
        }

        if (number == 0) {
            return 1;
        }

        int digitCount = 0;

        while (number != 0){
            number = number / 10;
            digitCount++;
        }
        return digitCount;
    }
}

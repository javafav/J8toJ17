package controlflow;

public class NumberToWords {
    public static void main(String[] args) {
        numberToWords(7865);

    }

    public static void numberToWords(int number) {
        if(number < 0){
            System.out.println("invalid Value");
            return;

        }
        if(number == 0){
            System.out.println("ZERO");
            return ;
        }
        int reverse = reverse(number);

        int leadingZero = getDigitCount(number) - getDigitCount(reverse);

        while (reverse != 0){
            int numberToWord = reverse % 10;
            switch (numberToWord){
                case 1 -> System.out.println("ONE");
                case 2 -> System.out.println("TWO");
                case 3 -> System.out.println("THREE");
                case 4 -> System.out.println("FOUR");
                case 5 -> System.out.println("FIVE");
                case 6 -> System.out.println("SIX");
                case 7 -> System.out.println("SEVEN");
                case 8 -> System.out.println("EIGHT");
                case 9 -> System.out.println("NINE");


            }
            reverse = reverse /10;
        }
        for(int i = 0; i < leadingZero; i++){
            System.out.println("ZERO");
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

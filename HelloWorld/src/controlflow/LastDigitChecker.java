package controlflow;

public class LastDigitChecker {
    public static void main(String[] args) {
        System.out.println(  hasSameLastDigit (41, 22, 71) );

        System.out.println(  hasSameLastDigit (411, 224, 321) );
        System.out.println(  hasSameLastDigit (156, 369, 141) );
        System.out.println(  hasSameLastDigit (458, 47, 711) );

    }

        public static boolean isValid(int number) {
            return number >= 10 && number <= 1000;
        }

        public static boolean hasSameLastDigit(int a, int b, int c) {

            if (!isValid(a) || !isValid(b) || !isValid(c)) {
                return false;
            }

            int lastA = a % 10;
            int lastB = b % 10;
            int lastC = c % 10;
            return (lastA == lastB) || (lastA == lastC) || (lastB == lastC);
        }
    }



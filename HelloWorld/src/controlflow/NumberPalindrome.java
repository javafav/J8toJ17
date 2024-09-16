package controlflow;

public class NumberPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(71711));
        System.out.println(isPalindrome(717));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1010));
        System.out.println(isPalindrome(1025));

    }

    public static boolean isPalindrome(int number){
        int reverseNumberCheck = number;
        int reverse = 0;

        while (number != 0) {

         int lastDigit = number % 10;
             reverse = reverse * 10;
             reverse += lastDigit;
             number = number / 10;
        }
        return (reverseNumberCheck == reverse);

    }
}

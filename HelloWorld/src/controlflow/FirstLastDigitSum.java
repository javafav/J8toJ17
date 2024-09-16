package controlflow;

public class FirstLastDigitSum {
    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(10));
        System.out.println(sumFirstAndLastDigit(125));
        System.out.println(sumFirstAndLastDigit(178));
        System.out.println(sumFirstAndLastDigit(9584));
        System.out.println(sumFirstAndLastDigit(74154));
    }
    public  static int sumFirstAndLastDigit(int number){
        if(number < 0 ){
            return  -1;
        }

        int sumOfFirstAndLastDigit = 0;
            sumOfFirstAndLastDigit += number % 10;

        while (number >= 10){
             number = number / 10;

        }
        return  sumOfFirstAndLastDigit + number;
    }
}

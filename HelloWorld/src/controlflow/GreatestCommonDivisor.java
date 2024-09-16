package controlflow;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(12,30));

        System.out.println(getGreatestCommonDivisor(25,15));

        System.out.println(    getGreatestCommonDivisor(9, 18) );
    }

    public static  int getGreatestCommonDivisor(int number1, int number2){
        if(number1 < 10 || number2 < 10){
            return -1;
        }

        int greatestCommonDivisor = number1 < number2 ? number1 : number2;

        while(greatestCommonDivisor > 1){
            if(number1 % greatestCommonDivisor == 0 && number2 % greatestCommonDivisor == 0){
                break;
            }
            greatestCommonDivisor--;
        }
        return  greatestCommonDivisor;
    }
}

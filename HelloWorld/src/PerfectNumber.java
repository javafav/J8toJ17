public class PerfectNumber {
    public static void main(String[] args) {

        System.out.println(isPerfectNumber(28));
    }
    public static boolean isPerfectNumber(int number){
        if(number < 1){
            return false;
        }
        int sumOfDivisors = 0;
        int counter = 1;

        while (counter <= number){
            if(number % counter == 0){
                sumOfDivisors += counter;
                if(sumOfDivisors == number) break;

            }
            counter++;

        }
        return sumOfDivisors == number;

    }
}

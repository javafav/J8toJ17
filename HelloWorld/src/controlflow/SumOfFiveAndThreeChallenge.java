package controlflow;

public class SumOfFiveAndThreeChallenge {
    public static void main(String[] args) {
        int counter = 0;
        int totalSumOf3And5 = 0;

        for(int loopNumber = 1; loopNumber<= 1000; loopNumber++){
            if( (loopNumber % 3 == 0) && (loopNumber % 5 == 0) ){
                totalSumOf3And5 += loopNumber;
                System.out.println(loopNumber + " can be divided by both number 3 and 5");
                counter++;

            }
            if(counter == 5) {
                break;
            }
        }

        System.out.println("Sum of Numbers that can be divided  both number 3 and 5 is: " + totalSumOf3And5);
    }
}

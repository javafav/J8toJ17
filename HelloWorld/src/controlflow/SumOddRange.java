package controlflow;

public class SumOddRange {
    public static void main(String[] args) {

        System.out.println(sumOdd(1,100));
        System.out.println(sumOdd(-1,100));
        System.out.println(sumOdd(100,100));
        System.out.println(sumOdd(13,13));
        System.out.println(sumOdd(100,-100));
        System.out.println(sumOdd(100,1000));


    }
    public static boolean isOdd(int oddNumber){
        if(oddNumber < 0){
            return false;
        }

        if(oddNumber % 2 != 0){
            return true;
        }else {
            return false;
        }
    }

    public static long sumOdd(int start, int end){
        if((start < 0 || end < 0) || (end < start) ){
            return -1;
        }

        long oddSum = 0;

        for(int i = start; i <= end; i++){

            if(isOdd(i)){
                oddSum += i;
            }


        }
        return oddSum;
    }
}

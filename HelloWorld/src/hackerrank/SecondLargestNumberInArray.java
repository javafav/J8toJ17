package hackerrank;

import java.util.Arrays;

public class SecondLargestNumberInArray {
    public static void main(String[] args) {
        int[] n = {1,4,5,8,9,11,4,78,11,111,258,354};
        int number = findNumber(n);
        System.out.println(number);
    }
    public static int findNumber(int[] numbers){
        Arrays.sort(numbers);
        return numbers[numbers.length - 2];
    }
}

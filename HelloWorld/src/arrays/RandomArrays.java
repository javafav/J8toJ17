package arrays;

import java.util.Arrays;
import java.util.Random;

public class RandomArrays {
    public static void main(String[] args) {
        int[] firstArray = randomArray(10);
        System.out.println(Arrays.toString(firstArray));

        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        Arrays.fill(secondArray, 4);
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = randomArray(10);
        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);

        System.out.println(Arrays.toString(fourthArray));

        int[] smallerArray = Arrays.copyOf(thirdArray, 5);
        System.out.println(Arrays.toString(smallerArray));

        int[] largerArray = Arrays.copyOf(thirdArray, 15);

        System.out.println(Arrays.toString(largerArray));








    }
    public static int[] randomArray(int len){
        Random random = new Random();
        int[] intArray = new int[len];

        for(int  i = 0; i< len; i ++){
         intArray[i] =  random.nextInt(100);
        }


        return  intArray;
    }
}

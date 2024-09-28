package arrays;

import java.util.Arrays;
import java.util.Random;

public class ReverseArrays {
    public static void main(String[] args) {
        int[] randomArray = randomArray(10);
        Arrays.sort(randomArray);

        int[] descArray = Arrays.copyOf(randomArray, randomArray.length);
        System.out.println(Arrays.toString(descArray));

        int counter = 0;
        for (int i = descArray.length - 1; i >= 0 ; i--) {
            descArray[counter] =  randomArray[i];
            counter++;
        }

        System.out.println(Arrays.toString(descArray));
    }

    public static int[] randomArray(int len) {
        Random random = new Random();
        int[] intArray = new int[len];

        for (int i = 0; i < len; i++) {
            intArray[i] = random.nextInt(100);
        }


        return intArray;
    }
}

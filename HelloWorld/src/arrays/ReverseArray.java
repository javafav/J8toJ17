package arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] testArray = {5, 4, 3, 4, 5};
        reverse(testArray);
    }

    public static void reverse(int[] anyArray){
        System.out.println(Arrays.toString(anyArray));
        int maxIndex = anyArray.length -1 ;
        int halfIndex = maxIndex / 2;

        for(int i = 0; i < halfIndex; i++){
            int temp = anyArray[i];
            anyArray[i] = anyArray[maxIndex - i];
            anyArray[maxIndex - i] = temp;
        }
        System.out.println(Arrays.toString(anyArray));
    }
}

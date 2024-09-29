package arrays;

import java.util.Arrays;

public class ReverseArrayChallenge {
    public static void main(String[] args) {
        int[] testArray = {47,54,25,36,335,48};
        reverse(testArray);
    }

    public static void reverse(int[] anyArray){
        System.out.println("Original Array " + Arrays.toString(anyArray));
        int maxIndex = anyArray.length -1 ;
        int halfIndex = maxIndex / 2;

        for(int i = 0; i < halfIndex; i++){
            int temp = anyArray[maxIndex - i];
            anyArray[maxIndex - i] = anyArray[i];
            anyArray[i] = temp;
        }
        System.out.println("Reverse Array " +  Arrays.toString(anyArray));
    }

}

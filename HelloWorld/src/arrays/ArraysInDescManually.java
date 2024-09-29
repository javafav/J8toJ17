package arrays;

import java.util.Arrays;

public class ArraysInDescManually {
    public static void main(String[] args) {
      int[] testArray = {47,58,24,56,12,1,89,2,56};
        System.out.println(Arrays.toString( descArray(testArray) ));
    }

    public static int[] descArray(int[] anyArray) {
        int temp;
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 0; i < anyArray.length - 1; i++) {
                if (anyArray[i] < anyArray[i + 1]) {
                    temp = anyArray[i];
                    anyArray[i] = anyArray[i + 1];
                    anyArray[i + 1] = temp;
                    flag = true;
                }
            }
        }

        return anyArray;

    }
}

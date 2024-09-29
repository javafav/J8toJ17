package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinElementInArrays {
    public static void main(String[] args) {
        int[] userInput = getArray();
        System.out.println(Arrays.toString(userInput));
        System.out.println( "Min " + findMinElementInArray(userInput));
    }

    public static int[] getArray(){
        System.out.println("Please Enters the numbers in comma separated");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] splits = input.split(",");
        int[] values = new int[splits.length];
        for(int i = 0; i< values.length; i ++){
            values[i] = Integer.parseInt(splits[i].trim());
        }

        return values;
    }

    public static int findMinElementInArray(int[] anyArray){

     int min = anyArray[0];

     for(int el : anyArray){
         if(el < min){
             min = el;
         }
     }
     return min;

    }
}

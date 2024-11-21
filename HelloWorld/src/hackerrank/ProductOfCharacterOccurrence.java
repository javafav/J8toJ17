package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ProductOfCharacterOccurrence {
    public static void main(String[] args) {
        String s = "aabcdda";
        productOfCharacterOccurrence( s);
    }


    public static int productOfCharacterOccurrence( String s){

        Map<Character, Integer> charCount = new HashMap<>();

        for(char c : s.toCharArray()){
            charCount.put(c , charCount.getOrDefault(c , 0) + 1);
        }

        int product = 1;
        for(int count : charCount.values()){
            product *= count;
        }

        System.out.println(product);
        return product;
    }

}

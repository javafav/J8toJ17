package hackerrank;

import java.util.Arrays;
import java.util.Comparator;

public class GetSmallestAndLargestString {
    public static void main(String[] args) {
        System.out.println(   getSmallestAndLargest("helooworld", 2));

    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        for (int i = 0; i <= s.length()-k; i++) {
      smallest = s.substring(i, i+k).compareTo(smallest) < 0 ? s.substring(i, i+k) : smallest;
      largest = s.substring(i, i+k).compareTo(largest) > 0 ? s.substring(i, i+k) : largest;
        }

        return smallest + "\n" + largest;

    }
}

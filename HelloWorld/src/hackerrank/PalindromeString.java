package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String match = "";
        StringBuilder reverseString = new StringBuilder(A);
        String reversed = reverseString.reverse().toString();
        if(reversed.equals(A)){
            System.out.println("Yes");
//            System.out.println(A);
//            System.out.println(reversed);
        }else {
            System.out.println("Not");
        }

    }
}

package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println();
         isAnagram("eetst", "eeTst");
    }

    static boolean isAnagram(String a, String b) {
        // Complete the function
//first approach
//        a = a.toLowerCase();
//        b = b.toLowerCase();
//
//        if(a.length() != b.length()) {
//            System.out.println(a.length() + "  : " + b.length());
//          return false;
//        }
//        char[] charArray1 = a.toCharArray();
//        char[] charArray2 = b.toCharArray();
//
//        Arrays.sort(charArray1);
//        Arrays.sort(charArray2);
//        return Arrays.equals(charArray1, charArray2);

        //second approach


        Scanner sc=new Scanner(System.in);
        String s1=a.toLowerCase();
        String s2=b.toLowerCase();

        int [] countofs1= new int[26];
        int [] countofs2= new int[26];
        for(char c:s1.toCharArray()){
            System.out.print(  countofs1[c - 'a']++ );

        }

        System.out.println();
        for(char c:s2.toCharArray()){
            System.out.print( countofs2[c - 'a']++);

        }


        for(int i=0;i<26;i++){
            if(countofs1[i] != countofs2[i]){

                return false;
            }
        }

        return true;
    }
}
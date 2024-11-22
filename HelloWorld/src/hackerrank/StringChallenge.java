package hackerrank;

import java.util.Scanner;

public class StringChallenge {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        int sumOfTheLengths = A.length() + B.length();
       boolean flag = false;
        if((int)A.charAt(0) >= (int) B.charAt(0)){
            String temp = B;
            B = A;
            A = temp;
            flag = true;
        }
        System.out.println(sumOfTheLengths);
        if(flag){
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        String first = A.substring(0, 1 ).toUpperCase() + A.substring(1);
        String second = B.substring(0, 1 ).toUpperCase() + B.substring(1);
        System.out.println(first + " " + second);


    }
}

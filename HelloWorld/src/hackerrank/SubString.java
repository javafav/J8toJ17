package hackerrank;

import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        if(S.length() > 0){
            String finalString = S.substring(start, end);
            System.out.println(finalString);
        }
    }
}

package hackerrank;

import java.util.Scanner;

public class TokenString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
       s =  s.trim();

        String[] split = s.split("[ !,?._'@]+");
        // Write your code here.
        if(s.length() == 0){
            System.out.println(0);
        } else {
            System.out.println(split.length);
        }

        for(String ss : split){
            System.out.println(ss);
        }
        scan.close();
    }
    
}

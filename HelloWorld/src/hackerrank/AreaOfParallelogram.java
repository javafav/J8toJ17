package hackerrank;

import java.util.Scanner;

public class AreaOfParallelogram {
     static boolean flag;
    static int B,H;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
        try {
            if (B <= 0 || H <= 0) {
                throw new Exception(" Breadth and height must be positive");
            }
            System.out.println(B * H);
        }catch (Exception e){
            System.out.println(e);
        }

        }

    }


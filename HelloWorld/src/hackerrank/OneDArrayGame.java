package hackerrank;

import java.util.Scanner;

public class OneDArrayGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.

       for(int i =0; i < game.length; i++){
           if(game[i] == 0 || game[i + leap] == 0 && game.length < i + leap ){

               return true;
           }
       }

        return false;
    }
}

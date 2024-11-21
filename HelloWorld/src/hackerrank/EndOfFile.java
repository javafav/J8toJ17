package hackerrank;

import java.util.Scanner;

public class EndOfFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int lineCounter = 1;
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            System.out.println(lineCounter + " " + s);
            lineCounter++;

        }
    }
}

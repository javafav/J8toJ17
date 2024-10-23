package collections.maps;

import java.util.Scanner;

public class AdventureGameMain {
    public static void main(String[] args) {
        AdventureGame game = new AdventureGame();
        game.play("path");

        Scanner scanner = new Scanner(System.in);

        while (true){
            String direction = scanner.nextLine().trim().toUpperCase().substring(0,1);
            if(direction.equals("Q")) break;
            game.move(direction);

        }

    }
}

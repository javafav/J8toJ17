package games.console;


import games.console.game.pirate.Pirate;
import games.console.game.pirate.Weapon;

public class Main {

    public static void main(String[] args) {

//        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
//
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);

        Weapon weapon = Weapon.getWeaponByChar('P');
        System.out.println("weapons = " + weapon + ", hitPoints =  " + weapon.getHitPoint() + ", minLevel " + weapon.getMinLevel());

        var list = Weapon.getWeaponsByLevel(0);
        list.forEach(System.out::println);

        Pirate tim = new Pirate("Tim");
        System.out.println(tim);
    }
}

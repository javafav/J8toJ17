package games.console.game;

public record Shooter(String name) implements Player {

  public   boolean findPrize() {

        System.out.println("Prize found, score should be adjusted.");
        return false;
    }

  public   boolean useWeapon(String weapon) {

        System.out.println("You Shot your " + weapon);
        return false;
    }
}

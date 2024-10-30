package games.console.game.pirate;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum Weapon {
    KNIFE(0, 10),
    AXE(0, 30),
    MACHETE(1, 40),
    PISTOL(1, 50);

    private final int minLevel;
    private final int hitPoint;

    Weapon(int minLevel, int hitPoint) {
        this.minLevel = minLevel;
        this.hitPoint = hitPoint;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public static Weapon getWeaponByChar(char firstInitial){
        for(Weapon w : values()){
            if(w.name().charAt(0) == firstInitial){
                return w;
            }
        }
        return values()[0];
    }

    public List<Weapon> getWeaponsByLevel(int levelOfPlayer){
        List<Weapon> weapons = new ArrayList<>(EnumSet.of());
        for()

        return weapons;

    }
}

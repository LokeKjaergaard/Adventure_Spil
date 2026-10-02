import java.util.Random;
import java.util.Scanner;

public class Weapon extends Item {

    private int damage;
    private String meleeWeapon;
    private String longRangeWeapon;

    public Weapon(String shortName, String longName, int weight, int damage) {
        super(shortName, longName, weight);
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    Random random = new Random();
    public boolean bombExplode(){

        return random.nextBoolean();
    }

}

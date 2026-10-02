import java.util.Random;
import java.util.Scanner;

public class Weapon extends Item {

    private int damage;

    public Weapon(String shortName, String longName, int weight, int damage) {
        super(shortName, longName, weight);
        this.damage = damage;
    }

    Random random = new Random();
    public boolean bombExplode(){

        return random.nextBoolean();
    }

}

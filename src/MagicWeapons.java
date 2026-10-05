import java.util.Random;

public class MagicWeapons extends Weapon{
    private int charges;
    private int turnsSinceUse;

    public MagicWeapons(String shortName, String longName, int weight, int damage, int charges) {
        super(longName, shortName, weight, damage);
        this.charges = charges;
    }
@Override
public boolean canUse() {
    return charges > 0;
}
@Override
    public void use(){
        charges--;
        turnsSinceUse = 0;
}

}

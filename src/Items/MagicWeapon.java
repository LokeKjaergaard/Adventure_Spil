package Items;

public class MagicWeapon extends Weapon{
    private int charges;
    private int turnsSinceUse;

    public MagicWeapon(String shortName, String longName, int weight, int damage, int charges) {
        super(shortName, longName, weight, damage);
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

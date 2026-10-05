package Items;

public class RangedWeapon extends Weapon {

    private int ammunition;


    public RangedWeapon(String shortName, String longName, int weight, int damage, int ammunition) {
        super(longName, shortName, weight, damage);
        this.ammunition = ammunition;
    }

    @Override
    public boolean canUse() {
        return ammunition > 0;
    }

    @Override
    public void use() {
        ammunition--;
    }
}

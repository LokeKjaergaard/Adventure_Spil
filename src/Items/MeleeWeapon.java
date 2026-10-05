package Items;

public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String shortName, String longName, int weight, int damage){
        super(shortName, longName, weight, damage);

    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void use() {
    }


}

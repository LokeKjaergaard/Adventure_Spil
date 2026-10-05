public class ExplosiveWeapon extends Weapon {

    public ExplosiveWeapon(String shortName, String longName, int weight, int damage){
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






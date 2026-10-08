public class Fight {

    private Player player;
    private Enemy enemy;

    public enum AggressionType {
        PASSIVE,
        NEUTRAL,
        AGGRESSIVE
    }


    public Fight(Player player, String enemySortName) {
        this.player = player;
        this.enemy = player.getCurrentRoom().findEnemyByShortName(enemySortName);
    }


    /*
    public hitOutcome startFight() {
        switch (enemy.getAggression()) {
            case PASSIVE -> {
                return player.attack(enemy.getShortName());
            }

            case NEUTRAL -> {
                hitOutcome playerAttackOutcome = player.attack(enemy.getShortName());

                if (playerAttackOutcome == hitOutcome.ENEMY_DIED) {
                    enemy.getRoom().addItem(enemy.getWeapon());
                    enemy.getRoom().removeEnemy(enemy);
                    return playerAttackOutcome;

                } else {
                    return enemy.attack(player);c

                }
            }

            case AGGRESSIVE -> {
               hitOutcome enemyAttackOutcome = enemy.attack(player);
                if (enemyAttackOutcome == player.) {

                    System.out.println("you killed the enemy");
                    enemy.getRoom().addItem(enemy.getWeapon());
                    enemy.getRoom().removeEnemy(enemy);
                    return;
                } else {
                    enemy.attack(player);
                }

                player.attack(enemy.getShortName());

            }

}


    }
            */
}

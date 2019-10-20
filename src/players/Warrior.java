package players;

public class Warrior extends Hero  {
    public Warrior(int health, int damage) {
        super(health, damage, Ability.SAFE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        if (this.getHealth()>0){
            for (int i = 0; i <heroes.length ; i++) {
                if (heroes [i].getAbility().equals(Ability.SAFE_DAMAGE_AND_REVERT) && // warrior наносит удар получ от босса
                        heroes[i].getHealth()>0) {
                    boss.setHealth(boss.getHealth()-boss.getDamage());

                }
            }

        }

    }
}

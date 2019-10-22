package players;

public class Thor extends Hero  {
    public Thor(int health, int damage) {
        super(health, damage, Ability.BLOCK_OF_BOSS);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        if (this.getHealth()>0){
            for (int i = 0; i <heroes.length ; i++) {
                if (heroes [i].getAbility().equals(Ability.BLOCK_OF_BOSS) &&
                        heroes[i].getHealth()>0) {
                    boss.setDamage(boss.getDamage()-boss.getDamage());

                }
            }

        }

    }
}

package players;

public class Golem extends Hero  {
    public Golem(int health, int damage) {
        super(health, damage, Ability.PARTLY_PROTECTING_FROM_BOSS);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        if (this.getHealth()>0){
            for (int i = 0; i <heroes.length ; i++) {
                if (heroes [i].getAbility().equals(Ability.PARTLY_PROTECTING_FROM_BOSS) &&
                        heroes[i].getHealth()>=0 && boss.getHealth()>=0) {
                    boss.setDamage(boss.getDamage()/heroes [i].getHealth() );

                }
            }

        }

    }
}

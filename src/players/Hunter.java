package players;

import java.util.Random;

public class Hunter extends Hero {
    public Hunter(int health, int damage) {
        super(health, damage, Ability.CRITICAL_DAMAGE);
    }

    @Override
     public void applySuperAbility(Hero[] heroes, Boss boss) {
        if (this.getHealth()>0){
            for (int i = 0; i <heroes.length ; i++) {
                if (heroes [i].getAbility().equals(Ability.CRITICAL_DAMAGE) && heroes[i].getHealth()>0) {
                    Random r= new Random();
                    int low=2;
                    int high=4;
                    int randomNumber= r.nextInt(high-low)+low;

                    heroes[i].setDamage(boss.getHealth()-(heroes[i].getDamage()*randomNumber));

                }
            }

        }

    }
}

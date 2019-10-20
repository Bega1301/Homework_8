package players;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, Ability.BOOST);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        if (this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    heroes[i].setDamage((heroes[i].getDamage() + 5) );

                }
            }

        }

    }
}

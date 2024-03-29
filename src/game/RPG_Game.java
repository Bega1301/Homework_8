package game;


import players.*;

public class RPG_Game {


    public static void startGame() {
        Boss boss = new Boss(400, 30);
        Hero[] heroes = createHeroes();
        while (!isFinished(heroes, boss)) {
            round(heroes, boss);
        }


    }

    private static void round(Hero[] heroes, Boss boss) {

        bossHit(heroes, boss);
        heroesHit(heroes, boss);
        heroesApplySuperAbility(heroes, boss);
        printStatistics(heroes, boss);

    }

    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("______________________________________");
        System.out.println("Boss Health:" + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health: " + heroes[i].getHealth());


        }
        System.out.println("________________________________________");
    }

    private static void heroesApplySuperAbility(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {

                heroes[i].applySuperAbility(heroes, boss);
            }

        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {


                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }

        }
    }

    private static void bossHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() - boss.getDamage() < 0) {
                heroes[i].setHealth(0);
            } else {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }

        }
    }

    private static boolean isFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {

            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                System.out.println("Boss won!!!");
                break;

            }


        }
        return allHeroesDied;

    }


    private static Hero[] createHeroes() {
        Warrior warrior = new Warrior(100, 10);
        Medic medic = new Medic(100, 10);
        Hunter hunter = new Hunter(100, 10);
        Magic magic = new Magic(100, 10);
        Thor thor = new Thor(100, 10);
        Golem golem = new Golem(400, 2);
        Hero[] heroes = new Hero[]{warrior, medic, hunter, magic, thor, golem};

        return heroes;
    }
}


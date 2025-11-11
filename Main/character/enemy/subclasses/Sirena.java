package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class Sirena extends Enemy {

    public Sirena() {
        setName("Gumacan Sirena");
        setMaxHp(100);
        setHp(100);
        setAttackPower(12);
        setDefense(3);
        setSpeed(8);
        setSkillUsedTurn(3);

        setExpReward(60);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println("The Gumaca Sirena sings a haunting melody towards " + player.getName() + "!");

        int baseDamage = getAttackPower();
        if (baseDamage < 0) baseDamage = 0;

        double critChance = 0.15;
        if (Math.random() < critChance) {
            baseDamage *= 2;
            System.out.println("Critical hit!");
        }
        player.takeDamage(baseDamage);
    }
}

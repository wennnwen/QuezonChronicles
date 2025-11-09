package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class FlamingCandelarian extends Enemy {

    public FlamingCandelarian() {
        setName("Flaming Cadelarian");
        setMaxHp(80);
        setHp(80);
        setAttackPower(10);
        setDefense(7);
        setSpeed(7);

        setExpReward(120);

        setPossibleLoot(new Item[]{new Bibingka(), new Panutsa()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " releases a burst of flame from its torch!");

        int baseDamage = getAttackPower();
        if (baseDamage < 0) baseDamage = 0;

        double critChance = 0.2;
        if (Math.random() < critChance) {
            baseDamage *= 2;
            System.out.println("Critical hit!");
        }

        player.takeDamage(baseDamage);
    }
}

package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class LanggonisaLord extends Enemy {

    public LanggonisaLord() {
        setName("Langgonisa Lord");
        setMaxHp(40);
        setHp(40);
        setAttackPower(7);
        setDefense(5);
        setSpeed(5);

        setExpReward(50);

        // Possible loot — themed after Lucban’s specialties
        setPossibleLoot(new Item[]{new KipingDelight(), new Habhab()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " splashes burning oil! Greasy Splash!");

        int baseDamage = getAttackPower();
        if (baseDamage < 0) baseDamage = 0;

        // Critical Chance
        double critChance = 0.2;
        if (Math.random() < critChance) {
            System.out.println("Critical Hit!");
            baseDamage *= 2;
        }

        player.takeDamage(baseDamage);
    }
}

package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class SeaWidow extends Enemy {

    public SeaWidow() {
        setName("Sea Widow");
        // Mid game enemy - Town 3 (East)
        setMaxHp(85);
        setHp(85);
        setAttackPower(16);
        setDefense(6);
        setSpeed(8);

        setExpReward(70);

        // Possible loot
        setPossibleLoot(new Item[]{new AdobongPusit(), new DriedFishSnack()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " casts the Gleaming Deadly Hook at " + player.getName() + "!";
        centerHub.printRightTextWithTypeWriter(text);

        int attackPower = getAttackPower();

        double weakenChance = 0.3; // 30% chance
        if (Math.random() < weakenChance) {
        player.applyDebuff("attack down", 2); // or any value you want to decrease
        }

        player.takeDamage(attackPower);
    }
}

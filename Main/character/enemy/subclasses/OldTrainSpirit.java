package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class OldTrainSpirit extends Enemy {

    public OldTrainSpirit() {
        setName("Old Train Spirit");
        // Tougher miniboss with stun and charge
        setMaxHp(160);
        setHp(160);
        setAttackPower(28);
        setDefense(11);
        setSpeed(5);

        setExpReward(400);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }

    @Override
    public void enemyMove(Player player) {
        centerHub.printRightTextWithTypeWriter("The Old Train Spirit charges with unstoppable force!");
        centerHub.printRightTextWithTypeWriter("It uses its signature move: 'Iron Charge'!");

        // Calculate base damage
        int damage = getAttackPower() + 5; // Extra impact for the charge
        player.takeDamage(damage);

        // 25% chance to stun the player for 1 turn
        double chance = Math.random();
        if (chance < 0.25) {
            player.applyDebuff("stun", 1);
        }

        // Cool flavor feedback
        String text = getName() + " rattles the ground as it passes by!";
        centerHub.printRightTextWithTypeWriter(text);
    }
}
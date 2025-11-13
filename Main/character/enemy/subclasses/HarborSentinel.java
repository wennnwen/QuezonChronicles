package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class HarborSentinel extends Enemy {

    public HarborSentinel() {
        setName("Harbor Sentinel");
        setMaxHp(80);
        setHp(80);
        setAttackPower(16); 
        setDefense(12);     
        setSpeed(2);        

        setExpReward(220);

        // Possible loot
        setPossibleLoot(new Item[]{new Chami(), new CocoJam()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " uses Anchor Smash on " + player.getName() + "!";
        centerHub.printRightText(text);

        int attackPower = getAttackPower();

        // Critical hit mechanic
        double critChance = 0.15;
        if (Math.random() < critChance) {
            attackPower *= 2;
            centerHub.printRightText("Critical hit!");
        }

        // Deal damage
        player.takeDamage(attackPower);
    }
}

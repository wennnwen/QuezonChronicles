package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class HarborSentinel extends Enemy {

    public HarborSentinel() {
        setName("Harbor Sentinel");
        // Miniboss - Town 2
        setMaxHp(140);
        setHp(140);
        setAttackPower(20);
        setDefense(8);
        setSpeed(6);        

        setExpReward(150);

        // Possible loot
        setPossibleLoot(new Item[]{new Chami(), new CocoJam()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " uses Anchor Smash on " + player.getName() + "!";
        centerHub.printRightTextWithTypeWriter(text);

        int attackPower = getAttackPower();

        // Critical hit mechanic
        double critChance = 0.15;
        if (Math.random() < critChance) {
            attackPower *= 2;
            centerHub.printRightTextWithTypeWriter(textColor.RED + "Critical hit!" + textColor.RESET);
        }

        // Deal damage
        player.takeDamage(attackPower);
    }
}

package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class FlamingCandelarian extends Enemy {

    public FlamingCandelarian() {
        setName("Flaming Candelarian");
        // Mid-late game enemy - Town 4
        setMaxHp(105);
        setHp(105);
        setAttackPower(22);
        setDefense(9);
        setSpeed(10);

        setExpReward(95);

        setPossibleLoot(new Item[]{new Bibingka(), new Panutsa()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " releases a burst of flame from its torch!";
        centerHub.printRightTextWithTypeWriter(text);

        int baseDamage = getAttackPower();
        if (baseDamage < 0) baseDamage = 0;

        double critChance = 0.2;
        if (Math.random() < critChance) {
            baseDamage *= 2;
            centerHub.printRightTextWithTypeWriter(textColor.RED + "Critical hit!" + textColor.RESET);
        }

        player.takeDamage(baseDamage);
    }
}

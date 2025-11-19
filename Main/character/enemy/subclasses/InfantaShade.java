package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class InfantaShade extends Enemy {

    public InfantaShade() {
        setName("Infanta Shade");
        // Mid-late game enemy - Town 4 (East)
        setMaxHp(105);
        setHp(105);
        setAttackPower(22);
        setDefense(9);
        setSpeed(11);

        setExpReward(95);

        // Possible loot
        setPossibleLoot(new Item[]{new LambanogLecheFlan(), new MountainHoney()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " lashes out with shadowy energy at " + player.getName() + "!";
        centerHub.printRightTextWithTypeWriter(text);

        // Deal damage instead of healing
        player.takeDamage(getAttackPower());
    }
}

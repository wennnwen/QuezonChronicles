package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class InfantaShade extends Enemy {

    public InfantaShade() {
        setName("Infanta Shade");
        setMaxHp(80);
        setHp(80);
        setAttackPower(10); 
        setDefense(7);
        setSpeed(10);

        setExpReward(125);

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

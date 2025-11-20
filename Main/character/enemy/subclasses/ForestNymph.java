package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class ForestNymph extends Enemy {

    public ForestNymph() {
        setName("Forest Nymph");
        // Mid-late game enemy - Town 4 (East)
        setMaxHp(100);
        setHp(100);
        setAttackPower(21);
        setDefense(8);
        setSpeed(9);

        setExpReward(85);

        // Possible loot
        setPossibleLoot(new Item[]{new LambanogLecheFlan(), new MountainHoney()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " glows with green light as her wounds fade.";
        centerHub.printRightTextWithTypeWriter(text);

        //healherself
        heal(18);
        player.takeDamage(getAttackPower());
    }
}

package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class ForestNymph extends Enemy {

    public ForestNymph() {
        setName("Forest Nymph");
        setMaxHp(80);
        setHp(80);
        setAttackPower(10); 
        setDefense(8);
        setSpeed(10);

        setExpReward(125);

        // Possible loot
        setPossibleLoot(new Item[]{new LambanogLecheFlan(), new MountainHoney()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " glows with green light as her wounds fade.";
        centerHub.printRightText(text);

        //healherself
        heal(18);
        player.takeDamage(getAttackPower());
    }
}

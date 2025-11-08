package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class ForestNymph extends Enemy {

    public ForestNymph() {
        setName("Forest Nymph");
        setMaxHp(150);
        setHp(150);
        setAttackPower(10); 
        setDefense(8);
        setSpeed(10);

        setExpReward(125);

        // Possible loot
        setPossibleLoot(new Item[]{new LambanogLecheFlan(), new MountainHoney()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " glows with green light as her wounds fade.");

        //healherself
        heal(18);
        player.takeDamage(getAttackPower());
    }
}

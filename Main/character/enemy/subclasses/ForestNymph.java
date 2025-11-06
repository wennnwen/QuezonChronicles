package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class ForestNymph extends Enemy {

    public ForestNymph() {
        setName("Forest Nymph");
        setMaxHp(60);
        setHp(60);
        setAttackPower(12); 
        setDefense(8);
        setSpeed(10);

        setExpReward(60);

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

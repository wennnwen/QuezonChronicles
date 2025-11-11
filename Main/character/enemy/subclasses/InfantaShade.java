package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class InfantaShade extends Enemy {

    public InfantaShade() {
        setName("Infanta Shade");
        setMaxHp(100);
        setHp(100);
        setAttackPower(10); 
        setDefense(8);
        setSpeed(10);

        setExpReward(125);

        // Possible loot
        setPossibleLoot(new Item[]{new LambanogLecheFlan(), new MountainHoney()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " lashes out with shadowy energy at " + player.getName() + "!");

        // Deal damage instead of healing
        player.takeDamage(getAttackPower());
    }
}

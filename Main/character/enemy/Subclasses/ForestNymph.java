package Main.Character.Enemy.Subclasses;

import Main.Items.*;

public class ForestNymph extends Enemy {

    public ForestNymph() {
        setName("Forest Nymph");
        setMaxHp(60);
        setHp(60);
        setAttackPower(12); 
        setDefense(8);
        setSpeed(10);

        expReward = 60;

        // Possible Loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new LambanogLecheFlan();
        possibleLoot[1] = new MountainHoney();
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " glows with green light as her wounds fade.");

        //healherself
        heal(18);
        player.takeDamage(attackPower);
    }
}

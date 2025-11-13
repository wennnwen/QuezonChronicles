package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class FisherRogue extends Enemy {

    public FisherRogue() {
        setName("Fisher Rogue");
        setMaxHp(80);
        setHp(80);
        setAttackPower(13); 
        setDefense(7);
        setSpeed(14);

        setExpReward(85);

        // Possible loot
        setPossibleLoot(new Item[]{new AdobongPusit(), new DriedFishSnack()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " casts the Gleaming Deadly Hook at " + player.getName() + "!";
        centerHub.printRightText(text);

        int attackPower = getAttackPower();

        // Critical hit mechanic
        double critChance = 0.2; // 20% chance
        if (Math.random() < critChance) {
            attackPower *= 2;
            centerHub.printRightText("Critical hit!");
        }

        // Deal damage
        player.takeDamage(attackPower);
    }
}

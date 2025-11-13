package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class BibingkaElemental extends Enemy {

    public BibingkaElemental() {
        setName("Bibingka Elemental");
        setMaxHp(80);
        setHp(80);
        setAttackPower(10); 
        setDefense(5);
        setSpeed(8);

        setExpReward(95);

        // Possible loot
        setPossibleLoot(new Item[]{new Bibingka(), new Panutsa()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " casts Flaming Bibingka at " + player.getName() + "!";
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
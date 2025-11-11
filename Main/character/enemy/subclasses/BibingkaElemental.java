package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

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
        System.out.println(getName() + " casts Flaming Bibingka at " + player.getName() + "!");

        int attackPower = getAttackPower();

        // Critical hit mechanic
        double critChance = 0.2; // 20% chance
        if (Math.random() < critChance) {
            attackPower *= 2;
            System.out.println("Critical hit!");
        }

        // Deal damage
        player.takeDamage(attackPower);
    }
}
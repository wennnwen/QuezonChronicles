package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;

public class TiaongKnight extends Enemy {

    public TiaongKnight() {
        setName("Tiaong Knight");
        setMaxHp(100);
        setHp(100);
        setAttackPower(20); 
        setDefense(18);
        setSpeed(10);

        expReward = 60;

        // Possible Loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new Tinuto();
        possibleLoot[1] = new PugonCoffee();
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " heavily swings their sword at " + player.getName() + "!");

        int attackPower = getAttackPower();

        //Critical Damage
        double critChance = 0.5; //50% chance
        if (Math.random() < critChance) {
        attackPower *= 2;
        System.out.println("Critical Hit!");
}
        // Deal damage
        player.takeDamage(attackPower);
    }
}

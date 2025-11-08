package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class TiaongKnight extends Enemy {

    public TiaongKnight() {
        setName("Tiaong Knight");
        setMaxHp(150);
        setHp(150);
        setAttackPower(20); 
        setDefense(18);
        setSpeed(9);

        setExpReward(60);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
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

package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class RealSpecter extends Enemy {

    public RealSpecter() {
        setName("Real Specter");
        setMaxHp(100);
        setHp(100);
        setAttackPower(15); 
        setDefense(12);
        setSpeed(20);

        setExpReward(60);

        // Possible loot
        setPossibleLoot(new Item[]{new Tinuto(), new PugonCoffee()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " unleashes a blood-curdling shriek that chills " + player.getName() + " to the bone!");

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

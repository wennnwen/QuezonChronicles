package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class CoconutBrigade extends Enemy {

    public CoconutBrigade() {
        setName("Coconut Brigade");
        setMaxHp(60);
        setHp(60);
        setAttackPower(8);
        setDefense(6);
        setSpeed(9);

        setExpReward(60);

        setPossibleLoot(new Item[]{new Lambanog(), new Pinagong()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " hurls a spinning coconut toward " + player.getName());

        int baseDamage = getAttackPower();
        if (baseDamage < 0) baseDamage = 0;

        double critChance = 0.2;
        if(Math.random() < critChance){
            System.out.println("Critical Hit!");
            baseDamage *= 2;
        }

        player.takeDamage(baseDamage);
    }
}

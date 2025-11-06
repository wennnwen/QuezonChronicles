package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class TanimGuardian extends Enemy {

    public TanimGuardian() {
        setName("Tanim Guardian");
        setMaxHp(30);
        setHp(30);
        setAttackPower(8);
        setDefense(5);
        setSpeed(7);

        setExpReward(45);

        // Possible loot
        setPossibleLoot(new Item[]{new Habhab(), new LongganisangLucban()});
    }

    @Override
    public void enemyMove(Player player) {
    System.out.println(getName() + " attacks with a vine!");

    int baseDamage = getAttackPower();
    if (baseDamage < 0) baseDamage = 0;
    
    // Critical hit mechanic
    double critChance = 0.2;
    double critRoll = Math.random();
    if (critRoll < critChance) {
        baseDamage *= 2; // Critical hit doubles damage
        System.out.println("Critical hit!");
    }

    player.takeDamage(baseDamage);
    }
}

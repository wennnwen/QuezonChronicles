package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class HabhabBandit extends Enemy{
    
    public HabhabBandit() {
        setName("Habhab Bandit");
        setMaxHp(60);
        setHp(60);
        setAttackPower(8);
        setDefense(2);
        setSpeed(14);

        setExpReward(25);

        // Possible loot
        setPossibleLoot(new Item[]{new Habhab(), new LongganisangLucban()});
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + "stabs with speed!");

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
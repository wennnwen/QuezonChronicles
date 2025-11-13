package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class QueenAmihan extends Enemy {

    public QueenAmihan() {
        setName("Queen Amihan");
        setMaxHp(100);
        setHp(100);
        setAttackPower(10); 
        setDefense(6);
        setSpeed(25);

        setExpReward(1500);

        // Possible loot
        setPossibleLoot(new Item[]{new SinigangHipon(), new TropicalBreezeJuice()});
    }

   @Override
    public void enemyMove(Player player) {
    System.out.println(getName() + " conjures a towering wave, crashing it down on " + player.getName() + "!");

    int attackPower = getAttackPower();
    
    // Deal damage after applying effects
    player.takeDamage(attackPower);
    heal(getAttackPower() / 2);
    System.out.println(getName() + " heals for " + (getAttackPower() / 2) + " HP!");
    }
}

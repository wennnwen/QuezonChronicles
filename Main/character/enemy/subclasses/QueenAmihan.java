package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class QueenAmihan extends Enemy {

    public QueenAmihan() {
        setName("Queen Amihan");
        setMaxHp(200);
        setHp(200);
        setAttackPower(20); 
        setDefense(20);
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
    heal(getHp() + 1);

}


}

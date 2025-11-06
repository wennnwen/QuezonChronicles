package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;

public class WaveFiend extends Enemy {

    public WaveFiend() {
        setName("Wave Fiend");
        setMaxHp(60);
        setHp(60);
        setAttackPower(12); 
        setDefense(8);
        setSpeed(10);

        setExpReward(60);

        // Possible loot
        setPossibleLoot(new Item[]{new SinigangHipon(), new TropicalBreezeJuice()});
    }

   @Override
    public void enemyMove(Player player) {
    System.out.println(getName() + " conjures a towering wave, crashing it down on " + player.getName() + "!");

    int attackPower = getAttackPower();

    // Slamming Waves skill: Chance to lower player's attack power (uses debuff system)
    double weakenChance = 0.33; // 20% chance
    if (Math.random() < weakenChance) {
        player.applyDebuff("attack down", 2); // Applies "attack down" debuff for 2 turns
    }

    // Deal damage after applying effects
    player.takeDamage(attackPower);
}


}

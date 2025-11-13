package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class WaveFiend extends Enemy {

    public WaveFiend() {
        setName("Wave Fiend");
        setMaxHp(100);
        setHp(100);
        setAttackPower(5); 
        setDefense(1);
        setSpeed(10);

        setExpReward(650);

        // Possible loot
        setPossibleLoot(new Item[]{new SinigangHipon(), new TropicalBreezeJuice()});
    }

   @Override
    public void enemyMove(Player player) {
    String text = getName() + " conjures a towering wave, crashing it down on " + player.getName() + "!";
    centerHub.printRightText(text);

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

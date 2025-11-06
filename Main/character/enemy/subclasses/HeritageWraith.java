package Main.character.enemy.subclasses;

import Main.Items.*;

public class HeritageWraith extends Enemy{

    public HeritageWraith(){
        setName("Heritage Wraith");
        setMaxHp(50);
        setHp(50);
        setAttackPower(10);
        setDefense(8);
        setSpeed(11);

        // Experience reward
        expReward = 25;

        //Possible Loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new Pinagong();
        possibleLoot[1] = new Budin();
    }

    @Override
    public void enemyMove(Player player) {
    System.out.println(getName() + " lashes out with its shadowy claws at " + player.getName() + "!");

    int baseDamage = getAttackPower();
    if (baseDamage < 0) baseDamage = 0;

    // Critical hit mechanic
    double critChance = 0.2;
    double critRoll = Math.random();
    if (critRoll < critChance) {
        baseDamage *= 2; // Critical hit doubles damage
        System.out.println("Critical hit!");
    }

    //Defense debuff
    int defenseReduce = 1;
    int duration = 1;

        player.addDefenseDebuff(defenseReduce, duration);
        player.takeDamage(baseDamage);
    }
}
package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

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
        String text = getName() + " stabs with speed!";
        centerHub.printRightTextWithTypeWriter(text);

    int baseDamage = getAttackPower();
    if (baseDamage < 0) baseDamage = 0;

    // Critical hit mechanic
    double critChance = 0.2;
    double critRoll = Math.random();
    if (critRoll < critChance) {
        baseDamage *= 2; // Critical hit doubles damage
        centerHub.printRightTextWithTypeWriter("Critical hit!");
    }

        player.takeDamage(baseDamage);
    }
}
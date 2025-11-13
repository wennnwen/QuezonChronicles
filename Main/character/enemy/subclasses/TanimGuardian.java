package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class TanimGuardian extends Enemy {

    private CenterHub centerHub = new CenterHub();

    public TanimGuardian() {
        setName("Tanim Guardian");
        setMaxHp(110);
        setHp(110);
        setAttackPower(5);
        setDefense(2);
        setSpeed(6);

        setExpReward(45);

        // Possible loot
        setPossibleLoot(new Item[]{new Habhab(), new LongganisangLucban()});
    }

    @Override
    public void enemyMove(Player player) {
    String text = getName() + " attacks with a vine!";
    centerHub.printRightText(text);

    int baseDamage = getAttackPower();
    if (baseDamage < 0) baseDamage = 0;
    
    // Critical hit mechanic
    double critChance = 0.2;
    double critRoll = Math.random();
    if (critRoll < critChance) {
        baseDamage *= 2; // Critical hit doubles damage
        centerHub.printRightText("Critical hit!");
    }

    player.takeDamage(baseDamage);
    }
}

package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.printAlignmentHub.CenterHub;

public class LanggonisaLord extends Enemy {

    public LanggonisaLord() {
        setName("Langgonisa Lord");
        setMaxHp(40);
        setHp(40);
        setAttackPower(7);
        setDefense(5);
        setSpeed(5);

        setExpReward(50);

        // Possible loot — themed after Lucban’s specialties
        setPossibleLoot(new Item[]{new KipingDelight(), new Habhab()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " splashes burning oil! Greasy Splash!";
        centerHub.printRightText(text);

        int baseDamage = getAttackPower();
        if (baseDamage < 0) baseDamage = 0;
        player.takeDamage(baseDamage);

        double attackRoll = 0.5;

        if (Math.random() <= attackRoll) {
            if (getSkillUsedTurn() <= 0) {
                player.applyDebuff("burn", 2);
                setSkillUsedTurn(2);
            }
            else {
                updateSkillUsedTurn();
            }
        }

        if (getSkillUsedTurn() > 0) {
            updateSkillUsedTurn();
        }
    }
}

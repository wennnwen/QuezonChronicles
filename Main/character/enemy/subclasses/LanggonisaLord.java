package Main.character.enemy.subclasses;

import Main.item.*;
import Main.character.player.Player;
import Main.character.enemy.Enemy;
import Main.styles.printAlignmentHub.CenterHub;

public class LanggonisaLord extends Enemy {

    public LanggonisaLord() {
        setName("Langgonisa Lord");
        // Early game enemy - Town 1
        setMaxHp(55);
        setHp(55);
        setAttackPower(11);
        setDefense(4);
        setSpeed(5);

        setExpReward(35);

        // Possible loot — themed after Lucban’s specialties
        setPossibleLoot(new Item[]{new KipingDelight(), new Habhab()});
    }

    @Override
    public void enemyMove(Player player) {
        String text = getName() + " splashes burning oil! Greasy Splash!";
        centerHub.printRightTextWithTypeWriter(text);

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

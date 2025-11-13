package Main.character.enemy;

import Main.character.Character;
import Main.character.player.Player;
import Main.item.*;
import Main.printAlignmentHub.CenterHub;

public abstract class Enemy extends Character {

    protected CenterHub centerHub = new CenterHub();

    private int expReward;
    private Item[] possibleLoot = new Item[2];
    private int skillUsedTurn;

    public abstract void enemyMove(Player player);

    public Item dropLoot() {
        if (possibleLoot == null || possibleLoot.length == 0) {
            return null;
        }

        double roll = Math.random();
        if (roll < 0.4) {
            return possibleLoot[0];
        }
        else if (roll < 0.8 && roll >= 0.4) {
            return possibleLoot[1];
        }
        else {
            return null;
        }
    }

    public int getExpReward() {
        return expReward;
    }

    public void setExpReward(int amount) {
        expReward = amount;
    }

    public Item[] getPossibleLoot() {
        return possibleLoot;
    }

    public void setPossibleLoot(Item[] newPossibleLoot) {
        possibleLoot = newPossibleLoot;
    }

    public int getSkillUsedTurn() {
        return skillUsedTurn;
    }

    public void setSkillUsedTurn(int turns) {
        skillUsedTurn = turns;
    }

    public void updateSkillUsedTurn() {
        skillUsedTurn--;
    }

    public void takeDamage(int amount) {
        int reducedDamage = Math.max(0, amount - getDefense());
        setHp(getHp() - reducedDamage);
        System.out.println(getName() + " took " + String.valueOf(reducedDamage) + " damage.");
        if (getHp() <= 0) {
            setHp(0);
        }
    }
}
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

    //Debuff Methods
  public void applyDebuff(String type, int turns) {
    for (int i = 0; i < activeDebuffs.length; i++) {
        if (activeDebuffs[i] == null) {
            activeDebuffs[i] = type;
            debuffTurns[i] = turns;
            System.out.println(getName() + " is afflicted with " + type + " for " + turns + " turns!");
            return;
        }
    }
    System.out.println("Too many debuffs active!");
  }

  public void updateDebuffs() {
    for (int i = 0; i < activeDebuffs.length; i++) {
        if (activeDebuffs[i] != null) {
            debuffTurns[i]--;
            applyDebuffEffect(activeDebuffs[i]);

            if (debuffTurns[i] <= 0) {
                System.out.println(activeDebuffs[i] + " wore off!");
                activeDebuffs[i] = null;
            }
        }
    }
  }

  public void applyDebuffEffect(String debuff) {
        switch (debuff.toLowerCase()) {
            case "poison":
                System.out.println(getName() + " takes 2 poison damage!");
                takeDamage(2);
                break;
            case "burn":
                System.out.println(getName() + " takes 2 burn damage!");
                takeDamage(2);
                break;
            case "absorb":
                System.out.println(getName() + " feels weaker! Health had been absored by 2");
                takeDamage(2);
                break;
            case "defense down":
                System.out.println(getName() + " feels weaker! Defense temporarily reduced.");
                setDefense(getDefense() - 1);
                break;
            case "attack down":
                System.out.println(getName() + " feels their strength fade!");
                setAttackPower(getAttackPower() - 2);
                break;
            case "stun":
                System.out.println(getName() + " is stunned and cannot move!");
                break;
            case "confusion":
                System.out.println(getName() + " is confused by the masks!");
                break;             
        }
    }
}
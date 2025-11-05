package Main.Character.Player;

import Main.Items.*;

public class Player extends Character {
  private int experience, level = 1, nextExpLevel = 100;

  //Effect attributes
  private int attackBoostAmount = 0, attackBoostTurn = 0;
  private int defenseBoostAmount = 0, defenseBoostTurn = 0;

  private final Item[] inventory = new Item[10];
  private final String[] attackMoves = new String[4];

	public abstract void showStats();
  public abstract void levelStats();
  public abstract void useMove(int moveNumber, Character target);

	//getter
  public int getLevel() {
   return level;
  }

  public int getExp() {
    return experience;
  }

  public int getNextExpLevel() {
    return nextExpLevel;
  }

  public Item[] getInventory() {
    return inventory;
  }

	//setter
  public void addExp(int amount) {
    this.experience += amount;
    if (this.experience >= nextExpLevel) {
      levelUp();
    }
  }
 
  public void levelUp() {
    level++;
    System.out.println("You have leveled up to: " + level);
    nextExpLevel += 50;
    levelStats();
  }

  public void addItem(Item item) {
      for (int i = 0; i < item.length; i++) {
        if (inventory[i] == null) {
          inventory[i] = item;
          break;
        }
      }
  }

  public void showInventory() {
    for (int i = 0; i < inventory.length; i++) {
      Item item = inventory[i];
      if (item != null) {
        System.out.print((i + 1) + ". " + item.getName() + " - " + item.getDescription());
      }
    }
  }
  
  public void setMoves(String[] moves) {
    for (int i = 0; i < moves.length; i++) {
      attackMoves[i] = moves[i];
    }
  }
 
 public void showMoves() {
  for (String moves : attackMoves) {
    System.out.println(moves);
  }
 }

  //Temporary Effect Boost
  public void addTemporaryAttackBoost(int amount, int duration) {
    setAttackPower(getAttackPower() + amount);
    attackBoostAmount = amount;
    attackBoostTurn = duration;
    System.out.println(getName() + "'s Attack Power increased by " + amount + " for " + duration);
  }

  public void addTemporaryDefenseBoost(int amount, int duration) {
    setDefense(getDefense() + amount);
    defenseBoostAmount = amount;
    defenseBoostTurn = duration;
    System.out.println(getName() + "'s Defense increased by " + amount + " for " + duration);
  }

  public void updateTurnEffects() {

    //Attack Power
    if (attackBoostTurn > 0) {
      attackBoostTurn--;
      if (attackBoostTurn == 0) {
        setAttackPower(getAttackPower() - attackBoostAmount);
        System.out.println("Attack boost expired for " + getName() + "!");
        attackBoostAmount = 0;
      }
    }

    //Defense
    if (defenseBoostTurn > 0) {
      defenseBoostTurn--;
      if (defenseBoostTurn == 0) {
        setDefense(getDefense() - defenseBoostAmount);
        System.out.println("Defense boost expired for " + getName() + "!");
        defenseBoostAmount = 0;
      }
    }
  }
}
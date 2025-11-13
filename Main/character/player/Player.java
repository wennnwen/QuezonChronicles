package Main.character.player;

import Main.item.*;
import Main.character.Character;

public abstract class Player extends Character {
  private int experience, level = 1, nextExpLevel = 100;

  // Base stats (captured at character creation) to allow proper reset
  private int baseMaxHp = 0;
  private int baseStamina = 0;
  private int baseMaxStamina = 0;
  private int baseMp = 0;
  private int baseMaxMp = 0;
  private int baseDefense = 0;
  private int baseAttackPower = 0;
  private int baseSpeed = 0;
  private boolean usesMp = true;
  
  //Effect attributes
  private int attackBoostAmount = 0, attackBoostTurn = 0;
  private int defenseBoostAmount = 0, defenseBoostTurn = 0;
  private int defenseDebuffAmount = 0, defenseDebuffTurn = 0;

  private static Item[] inventory = new Item[10];
  private final String[] attackMoves = new String[4];
  private boolean lastActionSucceeded = false;

  public abstract void description();
	public abstract void showStats();
  public abstract void levelStats();
  public abstract void useMoves(int moveNumber, Character target);

	//getter
  public boolean getUsesMp() {
    return usesMp;
  }

  public boolean getUsesStamina() {
    return !usesMp;
  }

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
  public void setUsesMp(boolean usesMp) {
    this.usesMp = usesMp;
  }

  public void setLastActionSucceeded(boolean val) {
    this.lastActionSucceeded = val;
  }

  public boolean getLastActionSucceeded() {
    return this.lastActionSucceeded;
  }

  public void addExp(int amount) {
    if (amount <= 0) return;
    this.experience += amount;
    while (this.experience >= nextExpLevel) {
      this.experience -= nextExpLevel;
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
      for (int i = 0; i < inventory.length; i++) {
        if (inventory[i] == null) {
          inventory[i] = item;
          break;
        }
      }
  }

  public void removeItem(int index) {
    if (index >= 0 && index < inventory.length) {
      // Shift all subsequent items left so there are no gaps.
      for (int i = index; i < inventory.length - 1; i++) {
        inventory[i] = inventory[i + 1];
      }
      // Clear last slot
      inventory[inventory.length - 1] = null;
    }
  }

  public void showInventory() {
    System.out.println("\n|============================================== Inventory ==============================================|\n");
    inventorySorter();
    for (int i = 0; i < inventory.length; i++) {
      Item item = inventory[i];
      if (item != null) {
        System.out.println("  " + (i + 1) + ". " + item.getName() + " - " + item.getDescription());
      }
    }
    System.out.println("\n|=======================================================================================================|");
  }

  public static void inventorySorter() {
    int count = 0;
    for (int i = 0; i < inventory.length; i++) {
      if (inventory[i] != null) {
        inventory[count++] = inventory[i];
      }
    }
    for (int i = count; i < inventory.length; i++) {
      inventory[i] = null;
    }
  }
  
  public void setMoves(String[] moves) {
    for (int i = 0; i < moves.length & i < attackMoves.length; i++) {
      attackMoves[i] = moves[i];
    }
  }
 
 public void showMoves() {
  for (String moves : attackMoves) {
    if (moves != null) {
      System.out.println(moves);
    }
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

  public void addDebuff(int amount, int duration) {
    setDefense(getDefense() - amount);
    defenseDebuffAmount = amount;
    defenseDebuffTurn = duration;
    System.out.println(getName() + "'s Defense decreased by " + amount + " for " + duration);
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

    //Defense Debuff
    if (defenseDebuffTurn > 0) {
      defenseDebuffTurn--;
      if (defenseDebuffTurn == 0) {
        setDefense(getDefense() + defenseDebuffAmount);
        System.out.println("Defense debuff expired for " + getName() + "!");
        defenseDebuffAmount = 0;
      }
    }
  }

  public void setBaseStats(int baseMaxHp, int baseStamina, int baseMaxStamina, int baseMp, int baseMaxMp, int baseDefense, int baseAttackPower, int baseSpeed) {
    this.baseMaxHp = baseMaxHp;
    this.baseStamina = baseStamina;
    this.baseMaxStamina = baseMaxStamina;
    this.baseMp = baseMp;
    this.baseMaxMp = baseMaxMp;
    this.baseDefense = baseDefense;
    this.baseAttackPower = baseAttackPower;
    this.baseSpeed = baseSpeed;
  }

  // Reset player progress (called when player dies)
  public void resetProgress() {
    // Reset experience and level
    this.experience = 0;
    this.level = 1;
    this.nextExpLevel = 100;

    // Clear inventory
    for (int i = 0; i < inventory.length; i++) {
      inventory[i] = null;
    }

    // Reset temporary effect trackers
    attackBoostAmount = 0;
    attackBoostTurn = 0;
    defenseBoostAmount = 0;
    defenseBoostTurn = 0;
    defenseDebuffAmount = 0;
    defenseDebuffTurn = 0;

    // Remove debuffs from Character (inherited)
    removeDebuff();

    // Restore stats back to base (level 1) values captured at creation
    setMaxHp(baseMaxHp);
    setHp(baseMaxHp);

    setStamina(baseStamina);
    setMaxStamina(baseMaxStamina);

    setMp(baseMp);
    setMaxMp(baseMaxMp);

    setDefense(baseDefense);
    setAttackPower(baseAttackPower);
    setSpeed(baseSpeed);

    System.out.println(getName() + "'s progress has been reset to level 1 base stats due to death.");
  }
}
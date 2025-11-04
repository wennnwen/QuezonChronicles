public class Player extends Character {
  private int experience, level = 1, nextExpLevel = 100, currency;

  //Debuffs
  private String[] activeDebuffs = new String[3];
  private int[] debuffTurns = new int[5];

  //Effect attributes
  private int attackBoostAmount = 0, attackBoostTurn = 0;
  private int defenseBoostAmount = 0, defenseBoostTurn = 0;

  private final Item[] inventory = new Item[10];
  private final String[] attackMoves = new String[4];

	public abstract void showStats();
  public abstract void levelStats();
  public abstract void showMoves();

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

	//setter
  public void addExp(int amount) {
    this.experience += amount;
    if (this.experience >= nextExpLevel) {
      levelUp();
    }
  }
 
  public static void levelUp() {
    level++;
    System.out.println("You have leveled up to: " + level);
    nextExpLevel += 50;
    levelStats();
  }

  public void addItem(Items item) {
      for (int i = 0; i > item.length; i++) {
        if (inventory[i] = null) {
          inventory[i] = item;
          break;
        }
      }
  }

  public void showInventory() {
    for (Items item : inventory) {
      int i = 1;
      System.out.printf("{i}. {item}\n");
      i++;
    }
  }
  
  public void setMoves(String[] moves) {
    for (int i = 0; i < moves.length; i++) {
      attackMoves[i] = moves[i];
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

  private void applyDebuffEffect(String debuff) {
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
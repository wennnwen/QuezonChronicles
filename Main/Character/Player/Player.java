public class Player extends Character {
  private int experience, level = 1, nextExpLevel = 100, curremcy/

  //Effect attributes
  private int attackBoostAmount = 0, attackBoostTurn = 0;
  private int defenseBoostAmount = 0, defenseBoostTurn = 0;
  private int defenseDebuffAmount = 0, defenseDebuffTurn = 0;

  private final Item[] inventory = new Item[10];
  private final String[] attackMoves = new String[4];

	public abstract void showStats();
  public abstract void levelStats();
  public abstract void showMoves();

	//getter
  public int getLevel() {
   return level;
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
 public void addTemporaryDefenseDebuff(int amount, int duration) {
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

    // Defense Debuff
    if (defenseDebuffTurn > 0) {
      defenseDebuffTurn--;
      if (defenseDebuffTurn == 0) {
        setDefense(getDefense() + defenseDebuffAmount); // restore defense
        System.out.println("Defense debuff expired for " + getName() + "!");
        defenseDebuffAmount = 0;
    }
}

  }
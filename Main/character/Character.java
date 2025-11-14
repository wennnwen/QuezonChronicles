package Main.character;

public abstract class Character {
  private String name;
  private int maxHp, hp, stamina, mp, attackPower, defense, speed, maxStamina, maxMp;

  //Debuff Attributes
  public String[] activeDebuffs = new String[3];
  public int[] debuffTurns = new int[3];

  //Stun Attribute
  private boolean isStunned;

  public abstract void takeDamage(int amount);

  public void heal(int amount) {
    System.out.println(name + " healed " + amount + " HP.");
    hp += amount;
    if (hp >= maxHp) {
      hp = maxHp;
    }
  } 

  public void addStamina(int amount) {
    System.out.println(name + " regained " + amount + " Stamina.");
    stamina += amount;
    if (stamina >= maxStamina) {
      stamina = maxStamina;
    }
  }

  public void addMp(int amount) {
    System.out.println(name + " regained " + amount + " MP.");
    mp += amount;
    if (mp >= maxMp) {
      mp = maxMp;
    }
  }

  public void addSpeed(int amount) {
    speed += amount;
  }

  public boolean isAlive() {
    return hp > 0;
  }

  //getters for Stats
  public String getName() {
    return name;
  }

  public int getMaxHp() {
    return maxHp;
  }

  public int getHp() {
    return hp;
  }

  public int getStamina() {
    return stamina;
  }

  public int getMaxStamina() {
    return maxStamina;
  }

  public int getMp() {
    return mp;
  }

  public int getMaxMp() {
    return maxMp;
  }

  public int getAttackPower() {
    return attackPower;
  }

  public int getDefense() {
    return defense;
  }

  public int getSpeed() {
    return speed;
  }

  public boolean getIsStunned() {
    return isStunned;
  }

	//setters for Stats
  public void setName(String newName) {
    name = newName;
  }
  
  public void setMaxHp(int newMaxHp) {
    maxHp = newMaxHp;
  }

  public void setHp(int newHp) {
    hp = newHp;
  }

  public void setStamina(int newStamina) {
    stamina = newStamina;
  }

  public void setMaxStamina(int newMaxStamina) {
    maxStamina = newMaxStamina;
  }

  public void setMp(int newMp) {
    mp = newMp;
  }

  public void setMaxMp(int newMaxMp) {
    maxMp = newMaxMp;
  }

  public void setAttackPower(int newAttackPower) {
    attackPower = newAttackPower;
  }

  public void setDefense(int newDefense) {
    defense = newDefense;
  }

  public void setSpeed(int newSpeed) {
    speed = newSpeed;
  }

  public abstract void applyDebuff(String type, int turns);
  public abstract void updateDebuffs();
  public abstract void applyDebuffEffect(String debuff);
  
  public void removeDebuff() {
    for (int i = 0; i < activeDebuffs.length; i++) {
      activeDebuffs[i] = null;
    }
    for (int i = 0; i < debuffTurns.length; i++) {
      debuffTurns[i] = 0;
    }
  }

  public void checkStunned() {
    isStunned = false;
    for (String debuff : activeDebuffs) {
      if (debuff != null && (debuff.equalsIgnoreCase("stun") || debuff.equalsIgnoreCase("confusion"))) {
        isStunned = true;
        break;
      }
    }
  }
}

package Main.character;

public abstract class Character {
  private String name;
  private int maxHp, hp, stamina, mp, attackPower, defense, speed, maxStamina, maxMp;

  //Debuff Attributes
  private String[] activeDebuffs = new String[3];
  private int[] debuffTurns = new int[3];

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

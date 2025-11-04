public abstract Class Character {
  private String name;
  private int maxHp, hp, stamina, mp, attackPower, defense, speed;

  public abstract void useMove(int moveNumber, Character target);
  
  public void takeDamage(int amount) {
		hp -= amount;
  }

  public void heal(int amount) {
		hp += amount;
  } 

  public void addStamina(int amount) {
    stamina += amount;
  }

  public void addMp(int amount) {
    mp += amount;
  }

  public void addSpeed(int amount) {
    speed += amount;
  }

  public bool isAlive() {
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

  public int getMp() {
    return mp;
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

	//setters for Stats
  public void setMaxHp(int newMaxHp) {
    this.maxHp = newMaxHp;
  }

  public void setHp(int newHp) {
    this.hp = newHp;
  }

  public void setStamina(int newStamina) {
    this.stamina = newStamina;
  }

  public void setMp(int newMp) {
    this.mp = newMp;
  }

  public void setAttackPower(int newAttackPower) {
    this.attackPower = newAttackPower;
  }

  public void setDefense(int newDefense) {
    this.defense = newDefense;
  }

  public void setSpeed(int newSpeed) {
    this.speed = newSpeed;
  }
}

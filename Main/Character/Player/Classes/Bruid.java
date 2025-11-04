public class Bruid extends Player {
  
  Bruid(String name) {
	setName(name);
    setMaxHp(60);
    setHp(60);
    setStamina(40);
    setDefense(6);
    setAttackPower(10);
    setSpeed(7);
   
  	setMoves(new String[] {"1. Banana Strike (Basic + no stamina required)", 
   							"2. Front Shield (Banana tree fronds wrap around the character, reducing incoming damage by 25% for 2 turns.)", 
   							"3. Healing Grove (Restores moderate HP, using the banana tree's life force.)", 
   							"4. Puso ng Saging (The druid summons a giant banana heart that explodes, dealing heavy damage and a 20% chance to stun.)"});
	}
 
	public void useMoves(int moveNumber, Character target) {
    switch (moveNumber) {
      case 1:
        
   		}
	}

	public void showMoves() {
		for (String moves : attackMoves)
	}

	public void showStats() {
		System.out.println("====Stats====");
		System.out.println("Health: " + getHp() + "/" + getMaxHp());
		System.out.println("Stamina: " + getStamina());
		System.out.println("Defense: " + getDefense());
		System.out.println("Attack Power: " + getAttackPower());
		System.out.println("Speed: " + getSpeed());
	}

	public void levelStats() {
 		setMaxHp(getMaxHp() + 8);
		setHp(getHp() + 8);
		setStamina(getStamina() + 8);
		setDefense(getDefense() + 2);
		setAttackPower(getAttackPower() + 2);
		setSpeed(getSpeed() + 1);
	}
}

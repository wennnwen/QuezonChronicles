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
   												"3. Healing Grove (Restores moderate HP, using the banana tree's life force.)"} 
  }
 
	public void useMoves(int moveNumber, Character target) {
    switch (moveNumber) {
      case 1:
        
    }
  }
}

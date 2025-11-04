package Main.Character.Player.Classes;

public class Bruid extends Player {
  
	Bruid(String name) {
		setName(name);
   		setMaxHp(60);
   		setHp(60);
   		setMp(40);
   		setDefense(6);
   		setAttackPower(10);
   		setSpeed(7);
   
  		setMoves(new String[] {"1. Banana Strike (Basic + no mana required)", 
   							"2. Front Shield (Banana tree fronds wrap around the character, reducing incoming damage by 25% for 2 turns. 10 MP)", 
   							"3. Healing Grove (Restores moderate MP, using the banana tree's life force.)", 
   							"4. Puso ng Saging (The druid summons a giant banana heart that explodes, dealing heavy damage and a 20% chance to stun. 15 MP)"});
	}
	
	@overrides 
	public void useMoves(int moveNumber, Character target) {
    switch (moveNumber) {
      	case 1:
			System.out.println(getName() + " used Banana Strike!");
			target.takeDamage(getAttackPower());
			break;

		case 2:
			if (getMp() >= 10) {
				System.out.println(getName() + " used Front Shield!");
				setMp(getMp() - 10);
				addTemporaryDefenseBoost((int)(getDefense() * 0.25), 2);
			}
			else {
				System.out.println("Not enough Mana!");
			}
			break;

		case 3:
			System.out.println(getName() + " used Healing Grove!");
			setMp(getMp() + 25);
			System.out.println("Mana Restored by 25 points!");
			break;

		case 4:
			if (getMp() >= 15) {
				System.out.println(getName() + " used Puso ng Saging!");
				setMp(getMp() - 15);
				int damage = getAttackPower() + (int)(getAttackPower() * 0.5);
				target.takeDamage(damage);
			}
			else {
				System.out.println("Not enough Mana!");
			}
			break;

		default:
			System.out.println("Invalid move number!");
			break;
		}
	}

	@overrides 
	public void showStats() {
		System.out.println("====Stats====");
		System.out.println("Health: " + getHp() + "/" + getMaxHp());
		System.out.println("Mana: " + getMp());
		System.out.println("Defense: " + getDefense());
		System.out.println("Attack Power: " + getAttackPower());
		System.out.println("Speed: " + getSpeed());
		System.out.println("Experience: " + getExp() + "/" + getNextExpLevel());
		System.out.println("Level: " + getLevel());
	}

	@overrides 
	public void levelStats() {
 		setMaxHp(getMaxHp() + 8);
		setHp(getHp() + 8);
		setMp(getMp() + 8);
		setDefense(getDefense() + 2);
		setAttackPower(getAttackPower() + 2);
		setSpeed(getSpeed() + 1);
	}
}

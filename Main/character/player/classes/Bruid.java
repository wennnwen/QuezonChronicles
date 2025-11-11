package Main.character.player.classes;

import Main.character.player.Player;
import Main.character.Character;

public class Bruid extends Player {
  
	public Bruid(String name) {
		setName(name);
   		setMaxHp(90);
   		setHp(90);
   		setMp(60);
		setMaxMp(60);
   		setDefense(6);
   		setAttackPower(8);
   		setSpeed(6);

      // Capture base stats for proper reset behavior
      setBaseStats(90, 0, 0, 60, 60, 6, 8, 6);
	  setUsesMp(true);
   
  		setMoves(new String[] {"1. Banana Strike (Basic + no mana required)", 
   							"2. Front Shield (Banana tree fronds wrap around the character, reducing incoming damage by 25% for 2 turns. 10 MP)", 
   							"3. Healing Grove (Restores moderate MP, using the banana tree's life force.)", 
   							"4. Puso ng Saging (The druid summons a giant banana heart that explodes, dealing heavy damage and a 20% chance to stun. 15 MP)"});
	}
	
	@Override
	public void useMoves(int moveNumber, Character target) {
    switch (moveNumber) {
      	case 1:
			System.out.println("\n" + getName() + " used Banana Strike!");
			target.takeDamage(getAttackPower());
			break;

		case 2:
			if (getMp() >= 10) {
				System.out.println("\n" + getName() + " used Front Shield!");
				setMp(getMp() - 10);
				addTemporaryDefenseBoost((int)(getDefense() * 0.25), 2);
			}
			else {
				System.out.println("Not enough Mana!");
			}
			break;

		case 3:
			System.out.println("\n" + getName() + " used Healing Grove!");
			setMp(getMp() + 25);
			System.out.println("Mana Restored by 25 points!");
			break;

		case 4:
			if (getMp() >= 15) {
				System.out.println("\n" + getName() + " used Puso ng Saging!");
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

	@Override
	public void showStats() {
		System.out.println("====Stats====");
		System.out.println("Health: " + getHp() + "/" + getMaxHp());
		System.out.println("Mana: " + getMp() + "/" + getMaxMp());
		System.out.println("Defense: " + getDefense());
		System.out.println("Attack Power: " + getAttackPower());
		System.out.println("Speed: " + getSpeed());
		System.out.println("Experience: " + getExp() + "/" + getNextExpLevel());
		System.out.println("Level: " + getLevel());
	}

	@Override 
	public void levelStats() {
 		setMaxHp(getMaxHp() + 8);
		setHp(getHp() + 8);
		setMp(getMp() + 8);
		setMaxMp(getMaxMp() + 8);
		setMaxStamina(getMaxStamina() + 8);
		setDefense(getDefense() + 2);
		setAttackPower(getAttackPower() + 2);
		setSpeed(getSpeed() + 1);
	}
}

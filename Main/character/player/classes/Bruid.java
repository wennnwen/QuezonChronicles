package Main.character.player.classes;

import Main.character.player.Player;
import Main.character.Character;
import Main.styles.printAlignmentHub.CenterHub;
import Main.styles.animationHub.TypeWriter;

public class Bruid extends Player {

	private CenterHub centerHub = new CenterHub();
  
	public Bruid(String name) {
		setName(name);
   		setMaxHp(90);
   		setHp(90);
   		setMp(60);
		setMaxMp(60);
   		setDefense(6);
   		setAttackPower(12);
   		setSpeed(6);
		description = 
				"Half forest guardian, half Bisakol wonder, the Bruid is a nature-touched warrior who draws strength from the sacred punò ng saging (banana tree).\n" +
				"Unlike typical druids who revere oaks or vines, the Bruid channels the resilience, flexibility, and masabaw na energy of the banana.\n" +
				"They are both protectors and pranksters of the wild, often seen communing with their leafy kin while humming folk tunes from the provinces.";

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
			String text = "\n" + getName() + " used Banana Strike!";
			typeWriter.typeWriterFast(text);
			target.takeDamage(getAttackPower());
			setLastActionSucceeded(true);
			break;

		case 2:
			if (getMp() >= 10) {
				text = "\n" + getName() + " used Front Shield!";
				typeWriter.typeWriterFast(text);
				setMp(getMp() - 10);
				addTemporaryDefenseBoost((int)(getDefense() * 0.25), 2);
				setLastActionSucceeded(true);
			}
			else {
				setLastActionSucceeded(false);
				
			}
			break;

		case 3:
			text = "\n" + getName() + " used Healing Grove!";
			typeWriter.typeWriterFast(text);
			addMp(25);
			setLastActionSucceeded(true);
			break;

		case 4:
			if (getMp() >= 15) {
				text = "\n" + getName() + " used Puso ng Saging!";
				typeWriter.typeWriterFast(text);
				setMp(getMp() - 15);
				int damage = getAttackPower() + (int)(getAttackPower() * 0.5);
				target.takeDamage(damage);
				setLastActionSucceeded(true);
			}
			else {
				setLastActionSucceeded(false);
			}
			break;

		default:
			typeWriter.typeWriterFast("Invalid move number!");
			setLastActionSucceeded(false);
			break;
		}
	}

	@Override
	public void showStats() {
		String text;
		System.out.println("===================================================================== Bruid Stats ==================================================================");
		text = "Health: " + String.valueOf(getHp()) + "/" + String.valueOf(getMaxHp());
    	centerHub.printCenteredText(text);
		text = "Mana: " + String.valueOf(getMp()) + "/" + String.valueOf(getMaxMp());
    	centerHub.printCenteredText(text);
		text = "Defense: " + String.valueOf(getDefense());
    	centerHub.printCenteredText(text);
		text = "Attack Power: " + String.valueOf(getAttackPower());
    	centerHub.printCenteredText(text);
		text = "Speed: " + String.valueOf(getSpeed());
    	centerHub.printCenteredText(text);
		text = "Experience: " + String.valueOf(getExp()) + "/" + String.valueOf(getNextExpLevel());
    	centerHub.printCenteredText(text);
		text = "Level: " + String.valueOf(getLevel());
    	centerHub.printCenteredText(text);
    	System.out.println("=====================================================================================================================================================");
	}

	@Override 
	public void levelStats() {
 		setMaxHp(getMaxHp() + 8);
		setHp(getHp() + 8);
		setMp(getMp() + 8);
		setMaxMp(getMaxMp() + 8);
		setDefense(getDefense() + 2);
		setAttackPower(getAttackPower() + 2);
		setSpeed(getSpeed() + 1);
	}
}

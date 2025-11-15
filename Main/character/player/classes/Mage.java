package Main.character.player.classes;

import Main.character.player.Player;
import Main.character.Character;
import Main.printAlignmentHub.CenterHub;

public class Mage extends Player {
   
   private static CenterHub centerHub = new CenterHub();

   public Mage(String name) {
      setName(name);
  		setMaxHp(70);
  		setHp(70);
  		setMp(120);
      setMaxMp(120);
  		setDefense(10);
  		setAttackPower(10);
  		setSpeed(20);
      description =
            "Masters of the mystical arts and occasional bakery enthusiasts, Mages command the elements with pure intellect — and sometimes pure chaos.\n" +
            "These spellcasters channel the raw forces of fire, mana, and… baked goods? Yes, through years of study (and late-night merienda),\n" +
            "Mages have discovered the secret arcane energy within pastries and pastries alone.";

      // Capture base stats for proper reset behavior
      setBaseStats(70, 0, 0, 120, 120, 10, 10, 20);
      setUsesMp(true);
   
  		setMoves(new String[] {"1. Fire Ball (Basic + no mana required)", 
   			"2. LambaShield (Creates a barrier that reduces incoming damage by 30% for 2 turns. 10 MP)", 
            "3. Mana Surge (Regenerates 20 MP instantly.)",
            "4. Pinagong Storm (Calls down hard pinagong breads on all enemies, deals heavy damage. 18 MP)"});
   }

	@Override
   public void useMoves(int moveNumber, Character target) {
      switch(moveNumber) {
         case 1:
            System.out.println("\n" + getName() + " cast a Fire Ball!");
            target.takeDamage(getAttackPower());
            setLastActionSucceeded(true);
            break;

         case 2:
            if (getMp() >= 10) {
               System.out.println("\n" + getName() + " cast a LambaShield!");
               setMp(getMp() - 10);
               addTemporaryDefenseBoost((int)(getDefense() * 0.30), 2);
               setLastActionSucceeded(true);
            }
            else {
               setLastActionSucceeded(false);
            }
            break;

         case 3:
            System.out.println("\n" + getName() + " cast a Mana Surge!");
            addMp(20);
			   System.out.println("Mana Restored by 20 points!");
            setLastActionSucceeded(true); 
            break;

         case 4:
            if (getMp() >= 18) {
               setMp(getMp() - 18);
               System.out.println("\n" + getName() + " cast a Pinagong Storm!");
               int damage = getAttackPower() + (int)(getAttackPower() * 0.5);
				   target.takeDamage(damage);
                  setLastActionSucceeded(true);
            }
            else {
               setLastActionSucceeded(false);
            }
            break;
      }
   }

	@Override
   public void showStats() {
		String text;
      System.out.println("===================================================================== Mage Stats ===================================================================");
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
 		setMaxHp(getMaxHp() + 5);
		setHp(getHp() + 5);
		setMp(getMp() + 5);
      setMaxMp(getMaxMp() + 5); 
		setDefense(getDefense() + 1);
		setAttackPower(getAttackPower() + 2);
		setSpeed(getSpeed() + 1);
	}
}

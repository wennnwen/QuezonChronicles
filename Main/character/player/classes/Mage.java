package Main.character.player.classes;

import Main.character.player.Player;
import Main.character.Character;

public class Mage extends Player {
   
   public Mage(String name) {
  		setMaxHp(45);
  		setHp(45);
  		setMp(35);
      setMaxMp(35);
  		setDefense(4);
  		setAttackPower(10);
  		setSpeed(8);
   
  		setMoves(new String[] {"1. Fire Ball (Basic + no mana required)", 
   			"2. LambaShield (Creates a barrier that reduces incoming damage by 30% for 2 turns. 10 MP)", 
            "3. Mana Surge (Regenerates 20 MP instantly.)",
            "4. Pinagong Storm (Calls down hard pinagong breads on all enemies, dealy heavy damage. 18 MP)"});
   }

	@Override
   public void useMoves(int moveNumber, Character target) {
      switch(moveNumber) {
         case 1:
            System.out.println(getName() + " cast a Fire Ball!");
            target.takeDamage(getAttackPower());
            break;

         case 2:
            if (getMp() >= 10) {
               System.out.println(getName() + " cast a LambaShield!");
               setMp(getMp() - 10);
               addTemporaryDefenseBoost((int)(getDefense() * 0.30), 2);
            }
            else {
               System.out.println("Not enough Mana!");
            }
            break;

         case 3:
            System.out.println(getName() + " cast a Mana Surge!");
            setMp(getMp() + 20);
			   System.out.println("Mana Restored by 20 points!");
            break;

         case 4:
            if (getMp() >= 18) {
               System.out.println(getName() + " cast a Pinagong Storm!");
               int damage = getAttackPower() + (int)(getAttackPower() * 0.5);
				   target.takeDamage(damage);
            }
            else {
               System.out.println("Not enough Mana!");
            }
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
 		setMaxHp(getMaxHp() + 5);
		setHp(getHp() + 5);
		setMp(getMp() + 5);
      setMaxMp(getMaxMp() + 5); 
		setDefense(getDefense() + 1);
		setAttackPower(getAttackPower() + 2);
		setSpeed(getSpeed() + 1);
	}
}

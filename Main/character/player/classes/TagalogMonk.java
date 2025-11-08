package Main.character.player.classes;

import Main.character.player.Player;
import Main.character.Character;

public class TagalogMonk extends Player {
   
   public TagalogMonk(String name) {
      setName(name);
  		setMaxHp(100);
  		setHp(100);
  		setStamina(45);
      setMaxStamina(45);
  		setDefense(7);
  		setAttackPower(10);
  		setSpeed(8);

      // Capture base stats for proper reset behavior
      setBaseStats(100, 45, 45, 0, 0, 7, 10, 8);
   
  		setMoves(new String[] {"1. Suntok ni Apo (basic + no stamina required)", 
   			"2. Bugso ng Loob (The monk releases a surge of inner energy, increasing attack power by 40% and dealing strong damage to a single enemy. (Cost: 10 Stamina))", 
            "3. Karma Strike (A powerful counterattack imbued with spiritual justice. Deals heavy damage and has a small chance to stun the target. (Cost: 15 Stamina))",
            "4. Dasal ng Katahimikan (The monk prays calmly amid battle, restoring a portion of HP and stamina while reducing incoming damage by 25% for 1 turn)"});
   }

	@Override
   public void useMoves(int moveNumber, Character target) {
      switch(moveNumber) {
         case 1:
            System.out.println("\n" + getName() + " used Suntok ni Apo!");
            target.takeDamage(getAttackPower());
            break;

         case 2:
            if (getStamina() >= 18) {
               System.out.println("\n" + getName() + " used Bugso ng Loob!");
               setStamina(getStamina() - 18);
               int boostDamage = getAttackPower() + (int)(getAttackPower() * 0.4);
               target.takeDamage(boostDamage);
            }
            else {
               System.out.println("Not enough Stamina!");
            }
            break;

         case 3:
            if (getStamina() >= 15) {
               System.out.println("\n" + getName() + " used a Karma Strike!");
               setStamina(getStamina() - 15);
			      int boostDamage = getAttackPower() + (int)(getAttackPower() * 0.2);
               target.takeDamage(boostDamage);
               double stunChance = Math.random();
                  if (stunChance < 0.15) {
                     System.out.println(target.getName() + " is stunned!");
                     target.applyDebuff("stun", 1);
                  }
            }
            else {
                System.out.println("Not enough Stamina!");
            }
            break;
            
         case 4:
            System.out.println("\n" + getName() + " used Dasal ng Katahimikan");
            System.out.println(getName() + "'s has healed and gained stamina!");
            heal((int)(getHp() * 0.3));
            addStamina(1);
			   addTemporaryDefenseBoost((int)(getDefense() * 0.25), 2);
            break;
      }
   }

	@Override
   public void showStats() {
		System.out.println("====Stats====");
		System.out.println("Health: " + getHp() + "/" + getMaxHp());
		System.out.println("Stamina: " + getStamina() + "/" + getMaxStamina());
		System.out.println("Defense: " + getDefense());
		System.out.println("Attack Power: " + getAttackPower());
		System.out.println("Speed: " + getSpeed());
		System.out.println("Experience: " + getExp() + "/" + getNextExpLevel());
		System.out.println("Level: " + getLevel());
	}

	@Override
   public void levelStats() {
 		setMaxHp(getMaxHp() + 6);
		setHp(getHp() + 6);
		setStamina(getStamina() + 2);
      setMaxStamina(getMaxStamina() + 2);
		setDefense(getDefense() + 2);
		setAttackPower(getAttackPower() + 2);
		setSpeed(getSpeed() + 1);
	}
}


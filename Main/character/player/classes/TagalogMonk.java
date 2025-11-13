package Main.character.player.classes;

import Main.character.player.Player;
import Main.character.Character;

public class TagalogMonk extends Player {

   public static int skillUsedTurn;
   
   public TagalogMonk(String name) {
      setName(name);
  		setMaxHp(100);
  		setHp(100);
  		setStamina(45);
      setMaxStamina(45);
  		setDefense(7);
  		setAttackPower(15);
  		setSpeed(8);

      // Capture base stats for proper reset behavior
      setBaseStats(100, 45, 45, 0, 0, 7, 10, 8);
      setUsesMp(false);
   
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
            setLastActionSucceeded(true);
            skillUsedTurn();
            break;

         case 2:
               if (getStamina() >= 10) {
                  System.out.println("\n" + getName() + " used Bugso ng Loob!");
                  setStamina(getStamina() - 10);
                  int boostDamage = getAttackPower() + (int)(getAttackPower() * 0.4);
                  target.takeDamage(boostDamage);
                  setLastActionSucceeded(true);
               }
               else {
                  System.out.println("Not enough Stamina!");
                  setLastActionSucceeded(false);
               }
            skillUsedTurn();
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
               setLastActionSucceeded(true);
            }
            else {
               System.out.println("Not enough Stamina!");
               setLastActionSucceeded(false);
            }
            skillUsedTurn();
            break;
            
         case 4:
            if (skillUsedTurn > 0) {
               System.out.println("You just used Dasal ng Katahimikan. Cannot use for 2 turns!");
               setLastActionSucceeded(false);
               break;
            }
            else {
               System.out.println("\n" + getName() + " used Dasal ng Katahimikan");
               System.out.println(getName() + "'s has healed and gained stamina!");
               heal((int)(getHp() * 0.3));
               addStamina(1);
               addTemporaryDefenseBoost((int)(getDefense() * 0.25), 2);
               skillUsedTurn = 2;
               setLastActionSucceeded(true);
               break;
            }

         default:
                System.out.println("Invalid move number!");
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

   public static void skillUsedTurn() {
      if (skillUsedTurn <= 0) {
         skillUsedTurn = 0;
      }
      else {
         skillUsedTurn--;
         if (skillUsedTurn == 0) {
            System.out.println("Dasal ng Katahimikan is ready!");
         }
      }
   }

   @Override
   public void description() {
      System.out.println("Steeped in the ancient traditions of the Tagalog highlands and lowlands, the Tagalog Monk embodies harmony between body, spirit, and the land.
                        \nGuided by pananampalataya (faith) and disiplina (discipline), these warriors channel the strength of their ancestors
                        \nfrom the mountains of the North to the plains of the heart of Luzon.");
   }
}


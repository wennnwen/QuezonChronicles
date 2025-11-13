package Main.character.player.classes;

import Main.character.player.Player;
import Main.character.Character;

public class Warrior extends Player{

    public static int skillUsedTurn;

    public Warrior(String name){
        setName(name);
        setMaxHp(130);
        setHp(130);
        setStamina(30);
        setMaxStamina(30);
        setDefense(10);
        setAttackPower(16);
        setSpeed(5);

        // Capture base stats for proper reset behavior
        setBaseStats(130, 50, 50, 0, 0, 10, 16, 5);
        setUsesMp(false);

        setMoves(new String[] {"1. Slash(Basic + no stamina required.)",
                                "2. Cleave(Swings the weapon with all your might which deals 150% of normal damage.",
                                "3. Shield Bash(Deals minor damage and has a chance to stun.)",
                                "4. Second Wind(Gain minor heal and stamina.)"});
    }

	@Override
    public void useMoves(int moveNumber, Character target) {
        switch(moveNumber){
            case 1:
                System.out.println("\n" + getName() + " used Slash!");
                target.takeDamage(getAttackPower());
                setLastActionSucceeded(true);
                skillUsedTurn();
                break;

            case 2:
                if (getStamina() >= 5){
                    System.out.println("\n" + getName() + " used Cleave!");
                    setStamina(getStamina() - 5);
                    target.takeDamage((int) (getAttackPower() * 1.5));
                    skillUsedTurn();
                    setLastActionSucceeded(true);
                    break;
                }
                else{
                    System.out.println("Not enough stamina!");
                    setLastActionSucceeded(false);
                }
                skillUsedTurn();
                break;

            case 3:
                if (getStamina() >= 3){
                    System.out.println("\n" + getName() + " used Shield Bash!");
                    target.takeDamage((int) (getAttackPower() * 0.5));
                    double stunChance = 0.25;
                    if(Math.random() <= stunChance){
                        target.applyDebuff("stun", 3);
                    }
                    setStamina(getStamina() - 3);
                    setLastActionSucceeded(true);
                    skillUsedTurn();
                    break;
                }
                else{
                    System.out.println("Not enough stamina!");
                    setLastActionSucceeded(false);
                }
                skillUsedTurn();
                break;

            case 4:
                if (skillUsedTurn > 0) {
                    System.out.println("\nSecond Wind is on cooldown for " + skillUsedTurn + " more turn(s).");
                    setLastActionSucceeded(false);
                    break;
                }
                else{
                    System.out.println("\n" + getName() + " used Second Wind!");
                    heal(15);
                    addStamina(10);
                    skillUsedTurn = 3;
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
 		setMaxHp(getMaxHp() + 8);
		setHp(getHp() + 8);
		setStamina(getStamina() + 4);
        setMaxStamina(getMaxStamina() + 4);
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
            System.out.println("Second Wind is ready!");
         }
      }
   }
}
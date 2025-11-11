package Main.character.player.classes;

import Main.character.player.Player;
import Main.character.Character;

public class Warrior extends Player{

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
                break;

            case 2:
                if (getStamina() >= 5){
                    System.out.println("\n" + getName() + " used Cleave!");
                    setStamina(getStamina() - 5);
                    target.takeDamage((int) (getAttackPower() * 1.5));
                    break;
                }
                else{
                    System.out.println("Not enough stamina!");
                }
                break;

            case 3:
                if (getStamina() >= 3){
                    System.out.println("\n" + getName() + " used Shield Bash!");
                    target.takeDamage((int) (getAttackPower() * 0.5));
                    double stunChance = 1.00;
                    if(Math.random() <= stunChance){
                        target.applyDebuff("stun", 3);
                    }
                    break;
                }
                else{
                    System.out.println("Not enough stamina!");
                }
                break;

            case 4:
                System.out.println("\n" + getName() + " used Second Wind!");
                System.out.println(getName() + "'s healed for +15hp and restored +10 stamina!");
                heal(15);
                addStamina(10);
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

}

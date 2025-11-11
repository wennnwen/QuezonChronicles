package Main.character.player.classes;

import Main.character.player.Player;
import Main.character.Character;

public class Thief extends Player{

    public Thief(String name){
        setName(name);
        setMaxHp(80);
        setHp(80);
        setStamina(60);
        setMaxStamina(60);
        setDefense(5);
        setAttackPower(25);
        setSpeed(12);

        // Capture base stats for proper reset behavior
        setBaseStats(80, 60, 60, 0, 0, 5, 11, 12);
        setUsesMp(false);

        setMoves(new String[] {"1. Stab (Basic + no stamina required)",
                                "2. Critical Edge (One strong hit that always lands critical damage (Cost: 10 Stamina))",
                                "3. Vanish (Become invisible for 2 turns. Avoid all attacks (Cost: 15 Stamina))",
                                "4. Looter's Instinct (regains small HP/stamina on successful steals)"});
        }   

	@Override
    public void useMoves(int moveNumber, Character target) {
        switch(moveNumber){
            case 1:
                System.out.println("\n" + getName() + " used Stab!");
                target.takeDamage(getAttackPower());
                break;

            case 2:
                if (getStamina() >= 10){
                    System.out.println("\n" + getName() + " used Critical Edge!");
                    setStamina(getStamina() - 10);
                    target.takeDamage(getAttackPower() * 2);
                }
                else {
                    System.out.println("Not enough Stamina!");
                }
                break;

            case 3:
                if (getStamina() >= 15){
                    System.out.println("\n" + getName() + " used Vanish!");
                    addTemporaryDefenseBoost(100, 2);
                    setStamina(getStamina() - 15);
                }
                else {
                    System.out.println("Not enough Stamina!");
                }
                break;

            case 4:
                System.out.println("\n" + getName() + " used Looter's Instinct!");
                heal(7);
                addStamina(7);
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
 		setMaxHp(getMaxHp() + 5);
		setHp(getHp() + 5);
		setStamina(getStamina() + 2);
        setMaxStamina(getMaxStamina() + 2);
		setDefense(getDefense() + 1);
		setAttackPower(getAttackPower() + 1);
		setSpeed(getSpeed() + 1);
	}
}


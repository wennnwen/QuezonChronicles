package Main.character.player.classes;

import Main.character.player.Player;
import Main.character.Character;
import Main.printAlignmentHub.CenterHub;

public class Thief extends Player{

    private CenterHub centerHub = new CenterHub();

    public Thief(String name){
        setName(name);
        setMaxHp(80);
        setHp(80);
        setStamina(60);
        setMaxStamina(60);
        setDefense(5);
        setAttackPower(25);
        setSpeed(12);
        description =
                "Swift, sly, and sharp as a blade hidden beneath a cloak, the Thief dances between the lines of law and survival.\n" +
                "Born from the bustling streets, back alleys, and midnight markets, Thieves are experts in deception, timing, and taking what the world refuses to give.\n\n" +
                "Where others see danger, the Thief sees opportunity. Every fight is a gamble, every strike a trick of the hand.\n" +
                "Armed with quick reflexes and a sharper wit, they slip through shadows, strike where it hurts, and vanish before justice can catch up.\n" +
                "In a world ruled by power, the Thief survives through diskarte.";

        // Capture base stats for proper reset behavior
        setBaseStats(80, 60, 60, 0, 0, 5, 25, 12);
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
                setLastActionSucceeded(true);
                break;

            case 2:
                if (getStamina() >= 10){
                    System.out.println("\n" + getName() + " used Critical Edge!");
                    setStamina(getStamina() - 10);
                    target.takeDamage(getAttackPower() * 2);
                    setLastActionSucceeded(true);
                }
                else {
                    setLastActionSucceeded(false);
                }
                break;

            case 3:
                if (getStamina() >= 15){
                    System.out.println("\n" + getName() + " used Vanish!");
                    addTemporaryDefenseBoost(100, 2);
                    setStamina(getStamina() - 15);
                    setLastActionSucceeded(true);
                }
                else {
                    setLastActionSucceeded(false);
                }
                break;

            case 4:
                System.out.println("\n" + getName() + " used Looter's Instinct!");
                heal(7);
                addStamina(7);
                setLastActionSucceeded(true);
                break;

            default:
                System.out.println("Invalid move number!");
                setLastActionSucceeded(false);
                break;
        }
    }

	@Override
    public void showStats() {
        String text;
		System.out.println("======================================================================Thief Stats===================================================================");
		text = "Health: " + String.valueOf(getHp()) + "/" + String.valueOf(getMaxHp());
        centerHub.printCenteredText(text);
        text = "Stamina: " + String.valueOf(getStamina()) + "/" + String.valueOf(getMaxStamina());
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
		setStamina(getStamina() + 2);
        setMaxStamina(getMaxStamina() + 2);
		setDefense(getDefense() + 1);
		setAttackPower(getAttackPower() + 1);
		setSpeed(getSpeed() + 1);
	}
}


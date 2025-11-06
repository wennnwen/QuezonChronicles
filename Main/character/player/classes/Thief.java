package Main.Character.Player.Classes;

public class Thief extends Player{

    Thief(String name){
        setName(name);
        setMaxHp(65);
        setHP(65);
        setStamina(40);
        setDefense(12);
        setAttackPower(18);
        setSpeed(15);

        setMoves(new String[] {"1. Stab (Basic + no stamina required)",
                                "2. Critical Edge (One strong hit that always lands critical damage (Cost: 10 Stamina))",
                                "3. Vanish (Become invisible for one turn. Avoid all attacks (Cost: 15 Stamina))",
                                "4. Smoke Bomb (Reduce enemy hit chance for 2 turns. (Cost: 15 Stamina))"});
        }   

	@overrides 
    public void useMoves(int moveNumber, Character target) {
        switch(moveNumber){
            case 1:
                System.out.println(getName() + " used Stab!");
                target.takeDamage(getAttackPower());
                break;

            case 2:
                if (getStamina() >= 10){
                    System.out.println(getName() + " used Critical Edge!");
                    setStamina(getStamina - 10);
                    target.takeDamage(getAttackPower() * 2);
                }
                else {
                    System.out.println("Not enough Stamina!");
                }
                break;

            case 3:
                if (getStamina() >= 15){
                    System.out.println(getName() + " used Vanish!");
                    //Become invisible
                }
                else {
                    System.out.println("Not enough Stamina!");
                }
                break;

            case 4:
                System.out.println(getName() + " used SmokeBomb!");
                //Reduce enemy hit chance.
                break;

            default:
                System.out.println("Invalid move number!");
                break;
        }
    }

	@overrides 
    public void showStats() {
		System.out.println("====Stats====");
		System.out.println("Health: " + getHp() + "/" + getMaxHp());
		System.out.println("Stamina: " + getMp());
		System.out.println("Defense: " + getDefense());
		System.out.println("Attack Power: " + getAttackPower());
		System.out.println("Speed: " + getSpeed());
		System.out.println("Experience: " + getExp() + "/" + getNextExpLevel());
		System.out.println("Level: " + getLevel());
	}
   
	@overrides 
	public void levelStats() {
 		setMaxHp(getMaxHp() + 5);
		setHp(getHp() + 5);
		setStamina(getStamina() + 2);
		setDefense(getDefense() + 1);
		setAttackPower(getAttackPower() + 1);
		setSpeed(getSpeed() + 1);
	}
}


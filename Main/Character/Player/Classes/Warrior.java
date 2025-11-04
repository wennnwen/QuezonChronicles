public class Warrior extends Player{

    Warrior(String name){
        setName(name);
        setMaxHp(65);
        setHP(65);
        setStamina(22);
        setDefense(8);
        setAttackPower(11);
        setSpeed(6);

        setMoves(new String[] {"1. Slash(Basic + no stamina required.)",
                                "2. Cleave(Swings the weapon with all your might which deals 150% of normal damage.",
                                "3. Shield Bash(Deals minor damage and has a chance to stun.)",
                                "4. Second Wind(Gain minor heal and stamina.)"});
    }

    public void useMoves(int moveNumber, Character target) {
        switch(moveNumber){
            case 1:
                System.out.println(getName() + " used Slash!");
                target.takeDamage(getAttackPower());
                break;

            case 2:
                if (getStamina() >= 5){
                    System.out.println(getName() + " used Cleave!");
                    setStamina(getStamina - 5);
                    target.takeDamage((int) (getAttackPower() * 1.5));
                    break;
                }

            case 3:
                if (getStamina() >= 3){
                    System.out.println(getName() + " used Shield Bash!")
                    target.takeDamage((int) (getAttackPower() * 0.5))
                    //chance to stun for 1 duration
                    //target.stun(1);
                    break;
                }

            case 4:
                System.out.println(getName() + " used Second Wind!");
                player.heal(15);
                player.addStamina(10);
                break;

            default:
                System.out.println("Invalid move number!");
                break;
        }
    }

    public void showMoves() {
        for (String moves : attackMoves) {
            System.out.println(moves);
        }
    }

    public void showStats() {
		System.out.println("====Stats====");
		System.out.println("Health: " + getHp() + "/" + getMaxHp());
		System.out.println("Mana: " + getMp());
		System.out.println("Defense: " + getDefense());
		System.out.println("Attack Power: " + getAttackPower());
		System.out.println("Speed: " + getSpeed());
		System.out.println("Experience: " + getExp() + "/" + getNextExpLevel());
		System.out.println("Level: " + getLevel());
	}

	public void levelStats() {
 		setMaxHp(getMaxHp() + 8);
		setHp(getHp() + 8);
		setStamina(getStamina() + 4);
		setDefense(getDefense() + 2);
		setAttackPower(getAttackPower() + 2);
		setSpeed(getSpeed() + 1);
	}

}

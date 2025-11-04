public class BibingkaElemental extends Enemy {

    public BibingkaElemental() {
        setName("Bibingka Elemental");
        setMaxHp(60);
        setHp(60);
        setAttackPower(12); 
        setDefense(8);
        setSpeed(10);

        expReward = 60;

        // Possible Loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new Bibingka();
        possibleLoot[1] = new Panutsa();
    }

    @Override
    public void enemyMove(Player player) {
        System.out.println(getName() + " casts Flaming Bibingka at " + player.getName() + "!");

        int attackPower = getAttackPower();

        // Critical hit mechanic
        double critChance = 0.2; // 20% chance
        if (Math.random() < critChance) {
            attackPower *= 2;
            System.out.println("Critical hit!");
        }

        // Deal damage
        player.takeDamage(attackPower);
    }
}

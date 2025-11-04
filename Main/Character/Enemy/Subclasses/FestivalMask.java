package Main.Character.Enemy.Subclasses;

import Main.Items.*;

public class SweetVendor extends Enemy {

    public SweetVendor() {
        setName("Sweet Vendor Spirit");
        setMaxHp(120);
        setHp(120);
        setAttackPower(16);
        setDefense(10);
        setSpeed(5);

        // Experience reward
        expReward = 80;

        // Possible loot
        possibleLoot = new Item[2];
        possibleLoot[0] = new Tinuto();
        possibleLoot[1] = new PugonCoffee();
    }
    @Override
    public void enemyMove(Player player) {
        System.out.println("\n👻 The Sweet Vendor Spirit attacks!");
        System.out.println("The spirit hurls enchanted sweets that explode on impact!");

        // Basic single move
        int damage = getAttackPower();
        player.takeDamage(damage);

        // Inflict burn debuff
        player.applyDebuff("burn", 3);

        // Drain stamina (only if the player uses stamina)
        if (player.getStamina() > 0) {
            int drain = 5;
            int newStamina = player.getStamina() - drain;
            if (newStamina < 0) newStamina = 0;
            player.setStamina(newStamina);
            System.out.println(player.getName() + "'s stamina is drained by " + drain + "!");
        }
        
        
    }
}

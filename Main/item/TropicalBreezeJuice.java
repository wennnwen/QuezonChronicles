
package Main.Items;

import Main.Character.Player.*;

public class TropicalBreezeJuice extends Items {

    public TropicalBreezeJuice() {
        setName("Tropical Breeze Juice");
        setDescription("(Begin a heroic journey where every decision alters your fate. Gives you stamina and speed.)");
    }

    @Override
    public void useItem(Player player) {
        int staminaBoost = 15;
        int speed = 3;
        
        //check if the class uses stamina or mp

        System.out.println(player.getName() + "ate the Mountain Honey!");
        System.out.println(player.getName() + "restores 15 amount of stamina!");

        player.addStamina(15);
        player.addSpeed(3);

    }
}

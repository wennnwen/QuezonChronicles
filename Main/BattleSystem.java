package Main;

import java.util.Scanner;
import Main.Character.*;
import Main.Items.*;

public class BattleSystem {

    public Scanner input = new Scanner(System.in);

    BattleSystem() {
        System.out.println("The battle has been initialized!");
    }

    public void BattleStart(Player player, Enemy enemy) {
        while (player.isAlive() && enemy.isAlive()) {

            System.out.println("Your Turn!");
            player.showMoves();
            System.out.println("5. Use item");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            if (choice >= 1 && choice <= 4) {
                player.useMoves(choice, enemy);
            }
            else if (choice == 5) {
                Item[] inventory = player.getInventory();
                System.out.print("Choose item number: ");
                int itemIndex = input.nextInt() - 1;
                inventory[itemIndex].useItem(player);
            }
            else {
                System.out.println("Invalid input. Enemy turn!");
            }

            System.out.println("Enemy Turn!");
            enemy.enemyMove(player);

            if (!enemy.isAlive()) {
                player.addExp();
            }
        }
    }
}
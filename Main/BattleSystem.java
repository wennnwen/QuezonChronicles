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

        boolean playerInitiative = false;

        if (player.getSpeed() > enemy.getSpeed()) {
            player.checkStunned()
            if (!player.getIsStunned()) {
                playerTurn(player, enemy);
                playerInitiative = true;
            }
        }
        
        else if (enemy.getSpeed() > player.getSpeed()) {
            enemy.checkStunned()
            if (!enemy.getIsStunned()) {
                enemyTurn(player, enemy);
            }
        }

        while (player.isAlive() && enemy.isAlive()) {
            if (playerInitiative) {
                enemy.checkStunned();
                if (!enemy.getIsStunned()) {
                    enemyTurn(player, enemy);
                    playerTurn(player, enemy);
                }
                else {
                    playerTurn(player, enemy);
                }
            }
            else {
                player.checkStunned();
                if (!player.getIsStunned()) {
                    playerTurn(player, enemy);
                    enemyTurn(player, enemy);
                }
                else {
                    enemyTurn(player, enemy);
                }
            }
        }
    }

    public void playerTurn(Player player, Enemy enemy) {
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
    }

    public void enemyTurn(Player player, Enemy enemy) {
        System.out.println("Enemy Turn!");
        enemy.enemyMove(player);

        if (!enemy.isAlive()) {
            player.addExp();
        }
    }
}
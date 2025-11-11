package Main.game;

import java.util.Scanner;
import Main.character.enemy.Enemy;
import Main.character.player.Player;
import Main.item.*;

public class BattleSystem {

    public Scanner input = new Scanner(System.in);

    public BattleSystem() {
        System.out.println("The battle has been initialized!");
    }

    public void BattleStart(Player player, Enemy enemy) {

        boolean playerInitiative = false;

        System.out.println("=========================================================================================================\nPlayer Stats:\t\t\tEnemy Stats:");
        System.out.println("Hp: " + player.getHp() + "/" + player.getMaxHp() + "\t\t\tHp: " + enemy.getHp() + "/" + enemy.getMaxHp());
        System.out.println("Stamina: " + player.getStamina() + "/" + player.getMaxStamina() + " | Mp: " + player.getMp() + "/" + player.getMaxMp());

        if (player.getSpeed() > enemy.getSpeed()) {
            System.out.println("\nPlayer goes first!");
            player.checkStunned();
            if (!player.getIsStunned()) {
                playerTurn(player, enemy);
                playerInitiative = true;
            }
        }
       
        else if (enemy.getSpeed() > player.getSpeed()) {
            System.out.println("\nEnemy goes first!");
            enemy.checkStunned();
            if (!enemy.getIsStunned()) {
                enemyTurn(player, enemy);
            }
        }

        while (player.isAlive() && enemy.isAlive()) {
            if (playerInitiative) {
                enemy.checkStunned();
                if (!enemy.getIsStunned()) {
                    // Enemy goes first this round. If their action kills the player,
                    // we should not run the player's turn. Likewise, if enemy is
                    // dead before the player's turn, skip the player's turn.
                    enemyTurn(player, enemy);
                    if (player.isAlive() && enemy.isAlive()) {
                        System.out.println("=========================================================================================================\nPlayer Stats:\t\t\tEnemy Stats:");
                        System.out.println("Hp: " + player.getHp() + "/" + player.getMaxHp() + "\t\t\tHp: " + enemy.getHp() + "/" + enemy.getMaxHp());
                        System.out.println("Stamina: " + player.getStamina() + "/" + player.getMaxStamina() + " | Mp: " + player.getMp() + "/" + player.getMaxMp());
                        playerTurn(player, enemy);
                    }
                }
                else {
                    playerTurn(player, enemy);
                }
            }
            else {
                System.out.println("=========================================================================================================\nPlayer Stats:\t\t\tEnemy Stats:");
                System.out.println("Hp: " + player.getHp() + "/" + player.getMaxHp() + "\t\t\tHp: " + enemy.getHp() + "/" + enemy.getMaxHp());
                System.out.println("Stamina: " + player.getStamina() + "/" + player.getMaxStamina() + " | Mp: " + player.getMp() + "/" + player.getMaxMp());
                player.checkStunned();
                if (!player.getIsStunned()) {
                    // Player acts first. If the player kills the enemy, don't let
                    // the (now dead) enemy take a turn.
                    playerTurn(player, enemy);
                    if (player.isAlive() && enemy.isAlive()) {
                        enemy.checkStunned();
                        if (!enemy.getIsStunned()) {
                            enemyTurn(player, enemy);
                        }
                    }
                }
                else {
                    enemyTurn(player, enemy);
                }
            }
        }

        handleVictory(player, enemy);

        if (!player.isAlive()) {
            System.out.println("Game over! You have been slained!");
            return;
        }
    }

    public void playerTurn(Player player, Enemy enemy) {
        System.out.println("\nYour moves:");
        player.showMoves();
        System.out.println("5. Use item");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        if (choice >= 1 && choice <= 4) {
            player.useMoves(choice, enemy);
        }
        else if (choice == 5) {
            Item[] inventory = player.getInventory();
            boolean isEmpty = true;
            // Only iterate when inventory is non-null and has slots
            if (inventory != null && inventory.length > 0) {
                for (int i = 0; i < inventory.length; i++) {
                    if (inventory[i] != null) {
                        isEmpty = false;
                        break;
                    }
                }
            }
            if (inventory == null || isEmpty) {
                System.out.println("Your inventory is empty!");
                return;
            } else {
                player.showInventory();
                System.out.print("Choose item number (Choose 0 to cancel): ");
                int itemIndex = input.nextInt() - 1;
                // Validate index and presence of item
                if (itemIndex == -1) {
                    System.out.println("Item use cancelled.");
                    return;
                }
                else if (itemIndex < -1 || itemIndex >= inventory.length || inventory[itemIndex] == null) {
                    System.out.println("Invalid item choice.");
                    return;
                }
                inventory[itemIndex].useItem(player);
                player.removeItem(itemIndex);
            }
        }
        else {
            System.out.println("Invalid input. Enemy turn!");
        }
    }

    public void enemyTurn(Player player, Enemy enemy) {
        System.out.println("Enemy Turn!");
        enemy.enemyMove(player);

        if (!(enemy.isAlive())) {
            player.addExp(enemy.getExpReward());
        }
    }

    public static void handleVictory(Player player, Enemy enemy) {
        // If enemy is dead and player is alive -> normal victory
        if (!enemy.isAlive() && player.isAlive()) {
            System.out.println("You defeated " + enemy.getName() + "!");
            player.addExp(enemy.getExpReward());
            System.out.println("You gained " + enemy.getExpReward() + " Exp from the battle!");
            Item loot = enemy.dropLoot();
            if (loot != null) {
                player.addItem(loot);
                // Print the item's name (Item has getName()) instead of the raw object
                System.out.println("You gained " + loot.getName() + " from the " + enemy.getName() + "!");
            } else {
                System.out.println("No loot dropped from " + enemy.getName() + ".");
            }
            return;
        }


        // If both have fallen in the same round
        if (!enemy.isAlive() && !player.isAlive()) {
            System.out.println("Both you and " + enemy.getName() + " have fallen!");
            Item loot = enemy.dropLoot();
            if (loot != null) {
                System.out.println("The " + enemy.getName() + " dropped " + loot.getName() + ", but you couldn't pick it up.");
            }
            return;
        }
    }
}   
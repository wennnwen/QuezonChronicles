package Main.game;

import java.util.Scanner;
import Main.character.enemy.Enemy;
import Main.character.player.Player;
import Main.item.*;
import Main.printAlignmentHub.CenterHub;

public class BattleSystem {

    public Scanner input = new Scanner(System.in);

    private CenterHub centerHub = new CenterHub();

    public BattleSystem() { }

    public void BattleStart(Player player, Enemy enemy) {

        boolean playerInitiative = false;

        System.out.println("=====================================================================================================================================================\nPlayer Stats:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnemy Stats:");
        System.out.println("Hp: " + player.getHp() + "/" + player.getMaxHp() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Hp: " + enemy.getHp() + "/" + enemy.getMaxHp());
        System.out.println("Stamina: " + player.getStamina() + "/" + player.getMaxStamina() + " | Mp: " + player.getMp() + "/" + player.getMaxMp());

        if (player.getSpeed() > enemy.getSpeed()) {
            System.out.print("\nPlayer goes first!");
            player.checkStunned();
            if (!player.getIsStunned()) {
                playerTurn(player, enemy);
                playerInitiative = true;
            }
        }
       
        else if (enemy.getSpeed() > player.getSpeed()) {
            String text = "\nEnemy goes first!";
            centerHub.printRightText(text);
            enemy.checkStunned();
            if (!enemy.getIsStunned()) {
                enemyTurn(player, enemy);
                enemy.updateSkillUsedTurn();
            }
        }
        else {
            double chances = Math.random();
            if (chances < 0.5) {
                System.out.println("\nPlayer goes first!");
                player.checkStunned();
                if (!player.getIsStunned()) {
                    playerTurn(player, enemy);
                    playerInitiative = true;
                }
            }
            else {
                String text = "\nEnemy goes first!";
                centerHub.printRightText(text);
                enemy.checkStunned();
                if (!enemy.getIsStunned()) {
                    enemyTurn(player, enemy);
                    enemy.updateSkillUsedTurn();
                }
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
                    enemy.updateDebuffs();
                    player.updateDebuffs();
                    player.updateTurnEffects();
                    if (player.isAlive() && enemy.isAlive()) {
                        System.out.println("=====================================================================================================================================================\nPlayer Stats:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnemy Stats:");
                        System.out.println("Hp: " + player.getHp() + "/" + player.getMaxHp() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Hp: " + enemy.getHp() + "/" + enemy.getMaxHp());
                        System.out.println("Stamina: " + player.getStamina() + "/" + player.getMaxStamina() + " | Mp: " + player.getMp() + "/" + player.getMaxMp());
                        playerTurn(player, enemy);
                    }
                }
                else {
                    playerTurn(player, enemy);
                    player.updateDebuffs();
                    enemy.updateDebuffs();
                    player.updateTurnEffects();
                }
            }
            else {
                System.out.println("=====================================================================================================================================================\nPlayer Stats:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnemy Stats:");
                System.out.println("Hp: " + player.getHp() + "/" + player.getMaxHp() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Hp: " + enemy.getHp() + "/" + enemy.getMaxHp());
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
                        enemy.updateDebuffs();
                        player.updateDebuffs();
                        player.updateTurnEffects();
                        
                    }
                }
                else {
                    enemyTurn(player, enemy);
                    enemy.updateSkillUsedTurn();
                    enemy.updateDebuffs();
                    player.updateDebuffs();
                    player.updateTurnEffects();
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
        System.out.println("\nPlayer Turn / Your Turn:");
        boolean validInput = false;
        while (!validInput) {
            System.out.println("=====================================================================================================================================================");
            System.out.println("Your moves:");
            player.showMoves();
            System.out.println("5. Use item");
            System.out.println("=====================================================================================================================================================");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            if (choice >= 1 && choice <= 4) {
                // Reset the last-action flag, attempt the move, and only end input loop
                // if the move actually succeeded (had enough stamina/mp and wasn't on cooldown).
                player.setLastActionSucceeded(false);
                player.useMoves(choice, enemy);
                validInput = player.getLastActionSucceeded();
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
                } else {
                    player.showInventory();
                    centerHub.printCenteredText("0. Cancel / Back");
                    System.out.println("\n========================================================================================================================================================");
                    System.out.print("Choose: ");
                    int itemIndex = input.nextInt() - 1;
                    // Validate index and presence of item
                    if (itemIndex == -1) {
                        System.out.println("Item use cancelled.");
                    }
                    else if (itemIndex < -1 || itemIndex >= inventory.length || inventory[itemIndex] == null) {
                        System.out.println("Invalid item choice.");
                    }
                    else {
                        inventory[itemIndex].useItem(player);
                        player.removeItem(itemIndex);
                        validInput = true;
                    }
                }
            }
            else {
                System.out.println("Invalid input. Please try again!");
            }
        }
    }

    public void enemyTurn(Player player, Enemy enemy) {
        String text;
        text = "Enemy Turn!";
        centerHub.printRightText(text);
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
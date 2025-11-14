package Main.game;

import java.util.Scanner;
import Main.character.enemy.Enemy;
import Main.character.player.Player;
import Main.character.player.classes.*;
import Main.item.*;
import Main.game.BattleSystem;
import Main.worldBuilder.WorldMap;
import Main.worldBuilder.Town;
import Main.printAlignmentHub.CenterHub;
import Main.clearScreen.ClearScreen;

public class GameMenu {

    private Player player;
    private Enemy enemy;
    private BattleSystem battleSystem = new BattleSystem();
    private CenterHub centerHub = new CenterHub();

    public Scanner input = new Scanner(System.in);
    private String name;
   
    public void showMainMenu() {
        String text;
        if (player == null) {
            System.out.println("=====================================================================================================================================================");
            text = "Create Character";
            centerHub.printCenteredText(text);
            System.out.print("Enter your name: ");
            name = input.nextLine();
        }
        while (player == null) {
            showClasses();
            inputMessager();
            int classChoice = input.nextInt();
            input.nextLine();

            switch (classChoice) {
                case 1:
                    int confirmChoice1;
                    do {
                        confirmationMessager();
                        confirmChoice1 = input.nextInt();
                        input.nextLine();
                        if (confirmChoice1 == 1) {
                            ClearScreen.clear();
                            player = new Bruid(name);
                            System.out.println("You have selected the Bruid class.");
                            break;
                        } 
                        else if (confirmChoice1 == 2) {
                            ClearScreen.clear();
                            player = new Bruid(name);
                            System.out.println("======================================================================== SKILLS =====================================================================");
                            for (int i = 0; i < player.getAttackMoves().length; i++) {
                                String move = player.getAttackMoves()[i];
                                centerHub.printCenteredText(move);
                            }
                            player = null;
                            System.out.println("=====================================================================================================================================================");
                        } 
                        else if (confirmChoice1 == 3) {
                            ClearScreen.clear();
                            player = null;
                            continue;
                        } else {
                            System.out.println("Invalid input. Try again.");
                        }
                    } while (confirmChoice1 != 3 && player == null);
                    break;
                
                case 2:
                    int confirmChoice2;
                    do {
                        confirmationMessager();
                        confirmChoice2 = input.nextInt();
                        input.nextLine();
                        if (confirmChoice2 == 1) {
                            ClearScreen.clear();
                            player = new Mage(name);
                            System.out.println("You have selected the Mage class.");
                            break;
                        }
                        else if (confirmChoice2 == 2) {
                            ClearScreen.clear();
                            player = new Mage(name);
                            System.out.println("======================================================================== SKILLS =====================================================================");
                            for (int i = 0; i < player.getAttackMoves().length; i++) {
                                String move = player.getAttackMoves()[i];
                                centerHub.printCenteredText(move);
                            }
                            player = null;
                            System.out.println("=====================================================================================================================================================");
                        } 
                        else if (confirmChoice2 == 3) {
                            ClearScreen.clear();
                            player = null;
                            continue;
                        } else {
                            System.out.println("Invalid input. Try again.");
                        }
                    } while (confirmChoice2 != 3 && player == null);
                    break;
                
                case 3:
                    int confirmChoice3;
                    do {
                        confirmationMessager();
                        confirmChoice3 = input.nextInt();
                        input.nextLine();
                        if (confirmChoice3 == 1) {
                            ClearScreen.clear();
                            player = new TagalogMonk(name);
                            System.out.println("You have selected the Tagalog Monk class.");
                        break;
                        }
                        else if (confirmChoice3 == 2) {
                            ClearScreen.clear();
                            player = new TagalogMonk(name);
                            System.out.println("======================================================================== SKILLS =====================================================================");
                            for (int i = 0; i < player.getAttackMoves().length; i++) {
                                String move = player.getAttackMoves()[i];
                                centerHub.printCenteredText(move);
                            }
                            player = null;
                            System.out.println("=====================================================================================================================================================");
                        } 
                        else if (confirmChoice3 == 3) {
                            ClearScreen.clear();
                            player = null;
                            continue;
                        } 
                        else {
                            System.out.println("Invalid input. Try again.");
                        }
                    } while (confirmChoice3 != 3 && player == null);
                    break;
                
                case 4:
                    int confirmChoice4;
                    do {
                        confirmationMessager();
                        confirmChoice4 = input.nextInt();
                        input.nextLine();
                        if (confirmChoice4 == 1) {
                            ClearScreen.clear();
                            player = new Thief(name);
                            System.out.println("You have selected the Thief class.");
                            break;
                        }
                        else if (confirmChoice4 == 2) {
                            ClearScreen.clear();
                            player = new Thief(name);
                            System.out.println("======================================================================== SKILLS =====================================================================");
                            for (int i = 0; i < player.getAttackMoves().length; i++) {
                                String move = player.getAttackMoves()[i];
                                centerHub.printCenteredText(move);
                            }
                            player = null;
                            System.out.println("=====================================================================================================================================================");
                        } 
                        else if (confirmChoice4 == 3) {
                            ClearScreen.clear();
                            player = null;
                            continue;
                        } 
                        else {
                            System.out.println("Invalid input. Try again.");
                        }
                    } while (confirmChoice4 != 3 && player == null);
                    break;
                
                case 5:
                    int confirmChoice5;
                    do {
                        confirmationMessager();
                        confirmChoice5 = input.nextInt();
                        input.nextLine();
                        if (confirmChoice5 == 1) {
                            ClearScreen.clear();
                            player = new Warrior(name);
                            System.out.println("You have selected the Warrior class.");
                            break;
                        }
                        else if (confirmChoice5 == 2) {
                            ClearScreen.clear();
                            player = new Warrior(name);
                            System.out.println("======================================================================== SKILLS =====================================================================");
                            for (int i = 0; i < player.getAttackMoves().length; i++) {
                                String move = player.getAttackMoves()[i];
                                centerHub.printCenteredText(move);
                            }
                            player = null;
                            System.out.println("=====================================================================================================================================================");
                        } 
                        else if (confirmChoice5 == 3) {
                            ClearScreen.clear();
                            player = null;
                            continue;
                        } 
                        else {
                            System.out.println("Invalid input. Try again.");
                        }
                    } while (confirmChoice5 != 3 && player == null);
                    break;

                default:
                    System.out.print("Invalid input. Try again.");
                    break;
            }
        }
        
        int choice = 0;
 		do {
            System.out.println("=====================================================================================================================================================");
            text = "( 1 ) Start Battle";
            centerHub.printCenteredText(text);
            text = "( 2 ) Show Stats";
            centerHub.printCenteredText(text);
            text = "( 3 ) Show Inventory";
            centerHub.printCenteredText(text);
            text = "( 4 ) Exit";
            centerHub.printCenteredText(text);
            System.out.println("=====================================================================================================================================================");
            inputMessager();
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    choosePath();
                    break;

                case 2:
                    ClearScreen.clear();
                    player.showStats();
                    break;

                case 3:
                    ClearScreen.clear();
                    Item[] inventory = player.getInventory();
                    boolean isEmpty = true;
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
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Game...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;     
            }
        } while (choice != 4);
    }
   
	public void inputMessager() {
  		System.out.print("Enter your choice: ");
    } 

    public void showClasses() {
        Player warrior = new Warrior("Temp");
        Player mage = new Mage("Temp");
        Player thief = new Thief("Temp");
        Player bruid = new Bruid("Temp");
        Player tagalogMonk = new TagalogMonk("Temp");
        String text;

        System.out.println("====================================================================== SELECT CLASS ===================================================================\n");
        text = "( 1 ) Bruid - The Banana Druid";
        centerHub.printCenteredText(text);
        centerHub.printCenteredText(bruid.description);
        System.out.println();
        text = "( 2 ) Mage - The Arcane Panadero";
        centerHub.printCenteredText(text);
        centerHub.printCenteredText(mage.description);
        System.out.println();
        text = "( 3 ) Tagalog Monk - The Disciple of Katahimikan";
        centerHub.printCenteredText(text);
        centerHub.printCenteredText(tagalogMonk.description);
        System.out.println();
        text = "( 4 ) Thief - The Shadow of the Kanto";
        centerHub.printCenteredText(text);
        centerHub.printCenteredText(thief.description);
        System.out.println();
        text = "( 5 ) Warrior - The Honor-bound Mandirigma";
        centerHub.printCenteredText(text);
        centerHub.printCenteredText(warrior.description);
        System.out.println("\n=====================================================================================================================================================");
    }

    public void confirmationMessager() {
        System.out.println("=====================================================================================================================================================");
        centerHub.printCenteredText("( 1 ) Confirm Character");
        centerHub.printCenteredText("( 2 ) View Skills");
        centerHub.printCenteredText("( 3 ) Re-select Class");
        System.out.println("=====================================================================================================================================================");
        inputMessager();
    }

    public void choosePath() {
        
        ClearScreen.clear();
        
        // Check if player has already chosen a path
        if (player.getChosenPath() != null) {
            System.out.println("=====================================================================================================================================================");
            centerHub.printCenteredText("You are currently on the " + player.getChosenPath().toUpperCase() + " path.");
            centerHub.printCenteredText("Resuming your progress...");
            System.out.println("=====================================================================================================================================================");
            
            Town resumeTown = player.getChosenPath().equals("west") ? 
                WorldMap.buildWestPath() : WorldMap.buildEastPath();
            
            // Navigate to the current town
            Town currentTown = resumeTown;
            for (int i = 0; i < player.getCurrentTownIndex(); i++) {
                currentTown = currentTown.getNextTown();
                if (currentTown == null) {
                    System.out.println("Error: Could not resume progress. Starting from beginning.");
                    player.setCurrentTownIndex(0);
                    currentTown = resumeTown;
                    break;
                }
            }
            
            currentTown.enterTown(player, player.getCurrentTownIndex());
            return;
        }
        
        // First time choosing a path
        System.out.println("=====================================================================================================================================================");
        centerHub.printCenteredText("\nWhich path would you like to take?");
        centerHub.printCenteredText("1. West Side Path");
        centerHub.printCenteredText("Lucban → Lucena (Miniboss) → Sariaya → Candelaria → Tiaong (Boss)");
        System.out.println();
        centerHub.printCenteredText("2. East Side Path");
        centerHub.printCenteredText("Gumaca → Lopez (Miniboss) → Calauag → Infanta → Real (Boss)");
        System.out.println("\n=====================================================================================================================================================");
        inputMessager();
        int choice = input.nextInt();
        Town startingTown;

        if (choice == 1) {
            ClearScreen.clear();
            System.out.println("You chose the West Side path!");
            player.setChosenPath("west");
            player.setCurrentTownIndex(0);
            startingTown = WorldMap.buildWestPath();
        } else if (choice == 2) {
            ClearScreen.clear();
            System.out.println("You chose the East Side path!");
            player.setChosenPath("east");
            player.setCurrentTownIndex(0);
            startingTown = WorldMap.buildEastPath();
        } else {
            ClearScreen.clear();
            System.out.println("Invalid choice. Defaulting to West Side.");
            player.setChosenPath("west");
            player.setCurrentTownIndex(0);
            startingTown = WorldMap.buildWestPath();
        }

        startingTown.enterTown(player, 0);
    }
}

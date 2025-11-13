package Main.game;

import java.util.Scanner;
import Main.character.enemy.Enemy;
import Main.character.player.Player;
import Main.character.player.classes.*;
import Main.item.*;
import Main.game.BattleSystem;
import Main.worldBuilder.WorldMap;
import Main.worldBuilder.Town;

public class GameMenu {

    private Player player;
    private Enemy enemy;
    private BattleSystem battleSystem = new BattleSystem();

    public Scanner input = new Scanner(System.in);
   
    public void showMainMenu() {
        System.out.println("==============================================================================================================");
        System.out.println("Create Character");
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        while (player == null) {
            showClasses();
            inputMessager();
            int classChoice = input.nextInt();
            input.nextLine();

            switch (classChoice) {
                case 1:
                    confirmationMessager();
                    int confirmChoice1 = input.nextInt();
                    input.nextLine();
                    if (confirmChoice1 == 1) {
                        player = new Bruid(name);
                        break;
                    } 
                    else if (confirmChoice1 == 2) {
                        player = new Bruid(name);
                        System.out.println("=============================Skills=============================");
                        for (String move : player.getMoves()) {
                            System.out.println(move);
                        }
                        System.out.println("================================================================");
                    } 
                    else if (confirmChoice1 == 3) {
                        player = null;
                        continue;
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;
                
                case 2:
                    confirmationMessager();
                    int confirmChoice2 = input.nextInt();
                    input.nextLine();
                    if (confirmChoice2 == 1) {
                        player = new Mage(name);
                        break;
                    }
                    else if (confirmChoice2 == 2) {
                        player = new Mage(name);
                        System.out.println("=============================Skills=============================");
                        for (String move : player.getMoves()) {
                            System.out.println(move);
                        }
                        System.out.println("================================================================");
                    } 
                    else if (confirmChoice2 == 3) {
                        player = null;
                        continue;
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;
                
                case 3:
                    confirmationMessager();
                    int confirmChoice3 = input.nextInt();
                    input.nextLine();
                    if (confirmChoice3 == 1) {
                        player = new Thief(name);
                        break;
                    }
                    else if (confirmChoice3 == 2) {
                        player = new Thief(name);
                        System.out.println("=============================Skills=============================");
                        for (String move : player.getMoves()) {
                            System.out.println(move);
                        }
                        System.out.println("================================================================");
                    } 
                    else if (confirmChoice3 == 3) {
                        player = null;
                        continue;
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;
                
                case 4:
                    confirmationMessager();
                    int confirmChoice4 = input.nextInt();
                    input.nextLine();
                    if (confirmChoice4 == 1) {
                        player = new Warrior(name);
                        break;
                    }
                    else if (confirmChoice4 == 2) {
                        player = new Warrior(name);
                        System.out.println("=============================Skills=============================");
                        for (String move : player.getMoves()) {
                            System.out.println(move);
                        }
                        System.out.println("================================================================");
                    } 
                    else if (confirmChoice4 == 3) {
                        player = null;
                        continue;
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;
                
                case 5:
                    confirmationMessager();
                    int confirmChoice5 = input.nextInt();
                    input.nextLine();
                    if (confirmChoice5 == 1) {
                        player = new TagalogMonk(name);
                        break;
                    }
                    else if (confirmChoice5 == 2) {
                        player = new TagalogMonk(name);
                        System.out.println("=============================Skills=============================");
                        for (String move : player.getMoves()) {
                            System.out.println(move);
                        }
                        System.out.println("================================================================");
                    } 
                    else if (confirmChoice5 == 3) {
                        player = null;
                        continue;
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;

                default:
                    System.out.print("Invalid input. Try again.");
                    break;
            }
        }
        
        int choice = 0;
 		do {
            System.out.println("|============================================================================================================|");
            System.out.println("1. Start Battle");
            System.out.println("2. Show Stats");
            System.out.println("3. Show Inventory");
            System.out.println("4. Exit");
            inputMessager();
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    choosePath();
                    break;

                case 2:
                    player.showStats();
                    break;

                case 3:
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

        System.out.println("============================================================Select Class=================================================");
        System.out.println("( 1 ) Bruid - The Banana Druid");
        bruid.description();
        System.out.println();
        System.out.println("( 2 ) Mage - The Arcane Panadero");
        mage.description();
        System.out.println();
        System.out.println("( 3 ) Tagalog Monk - The Disciple of Katahimikan");
        tagalogMonk.description();
        System.out.println();
        System.out.println("( 4 ) Thief - The Shadow of the Kanto");
        thief.description();
        System.out.println();
        System.out.println("( 5 ) Warrior - The Honor-bound Mandirigma");
        warrior.description();
        System.out.println("==========================================================================================================================");
    }

    public void confirmationMessager() {
        System.out.println("( 1 ) Confirm Character");
        System.out.println("( 2 ) View Skills");
        System.out.println("( 3 ) Re-select Class");
        inputMessager();
    }

    public void choosePath() {
        
        System.out.println("\nWhich path would you like to take?");
        System.out.println("1. West Side");
        System.out.println("   - Lucban → Lucena (Miniboss) → Sariaya → Candelaria → Tiaong (Boss)");
        System.out.println("2. East Side");
        System.out.println("   - Gumaca → Lopez (Miniboss) → Calauag → Infanta → Real (Boss)");
        inputMessager();
        int choice = input.nextInt();
        Town startingTown;

        if (choice == 1) {
            System.out.println("You chose the West Side path!");
            startingTown = WorldMap.buildWestPath();
        } else if (choice == 2) {
            System.out.println("You chose the East Side path!");
            startingTown = WorldMap.buildEastPath();
        } else {
            System.out.println("Invalid choice. Defaulting to West Side.");
            startingTown = WorldMap.buildWestPath();
        }

        startingTown.enterTown(player);
    }
}

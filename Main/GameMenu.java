package Main;

import java.util.Scanner;
import Main.Character.Player.*;
import Main.Items.*;
import Main.*;

public class GameMenu {

    private Player player;
    private Enemy enemy;
    private BattleSystem battleSystem = new BattleSystem();

    public Scanner input = new Scanner(System.in);
   
    public static void showMainMenu() {

 		do {
            System.out.println("Choose")
            System.out.println("1. Create a character");
            System.out.println("2. Show Stats");
            System.out.println("3. Show Inventory");
            System.out.println("4. Start Battle");
            System.out.println("5. Exit");
            inputMessager();
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = input.nextLine();

                    System.out.println("Choose a class you want: ");
                    System.out.println("1 - Warrior");
                    System.out.println("2 - Mage");
                    System.out.println("3 - Thief");
                    System.out.println("4 - Bruid");
                    System.out.println("5 - TagalogMonk");
                    inputMessager();
                    int classChoice = input.nextInt();
                    input.nextLine();

                    switch (classChoice) {
                        case 1:
                            player = new Warrior(name);
                            break;

                        case 2:
                            player = new Mage(name);
                            break;

                        case 3:
                            player = new Thief(name);
                            break;
                        
                        case 4:
                            player = new Bruid(name);
                            break;
                        
                        case 5:
                            player = new TagalogMonk(name);
                            break;
                        
                        default:
                            player = new Warrior(name);
                            System.out.print("Invalid input. Setting default Class (Warrior)");
                            break;
                    }

                case 2:
                    if (!characterValidation(player)) {
                        System.out.println("Please create character first.");
                        break;
                    }
                    player.showStats();
                    break;

                case 3:
                    if (!characterValidation(player)) {
                        System.out.println("Please create character first.");
                        break;
                    }
                    player.showInventory();
                    break;

                case 4:
                    choosePath();
                    break;
                
                case 5:
                    System.out.println("Exiting the Game...");
                    break;
            }
        } (choice != 5);
    }
   
	public static void inputMessager() {
  		System.out.print("Enter your choice: ");
    } 

    public boolean characterValidation(Player player) {
        return player = null;
    }

    public static void choosePath() {
        
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
            startingTown = WorldBuilder.buildWestPath();
        } else if (choice == 2) {
            System.out.println("You chose the East Side path!");
            startingTown = WorldBuilder.buildEastPath();
        } else {
            System.out.println("Invalid choice. Defaulting to West Side.");
            startingTown = WorldBuilder.buildWestPath();
        }

        startingTown.enterTown(player);
    }
}

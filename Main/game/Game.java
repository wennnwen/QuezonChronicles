package Main.game;

import Main.game.GameMenu;
import java.util.Scanner;
import Main.printAlignmentHub.CenterHub;

public class Game {
    private GameMenu menu;
    public Scanner input = new Scanner(System.in);
    private CenterHub centerHub = new CenterHub();

    public Game() {
        menu = new GameMenu();
    }
   
    public void start() {
        int choice;
        String text;
        System.out.println("Game Start!");
        do {
            System.out.println("=====================================================================================================================================================");
            text = "QUEZON CHRONICLES\n";
            centerHub.printCenteredText(text);
            text = "( 1 ) Start";;
            centerHub.printCenteredText(text);
            text = "( 2 ) About the Game";
            centerHub.printCenteredText(text);
            text = "( 3 ) Exit";
            centerHub.printCenteredText(text);
            System.out.println("=====================================================================================================================================================");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();
            
            switch (choice) {
                case 1:
                    menu.showMainMenu();
                    break;
                case 2:
                    System.out.println("=====================================================================About the Game==================================================================");
                    text = 
                        "Quezon Chronicles is an epic RPG adventure set in the Philippines.\n " +
                        "Embark on a journey through rich landscapes, " +
                        "encountering mythical creatures and historical figures.\n" +
                        "Uncover the secrets of the archipelago while battling foes, solving puzzles, " +
                        "and forging alliances.\n" +
                        "Experience a unique blend of Filipino culture and mythology in this captivating quest for glory!";
                    centerHub.printCenteredText(text);
                    System.out.println("=====================================================================================================================================================");
                    break;
                case 3:
                    System.out.println("Exiting the game. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);
    }
}
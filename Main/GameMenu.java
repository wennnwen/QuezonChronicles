package Main;

import java.util.Scanner;

public class GameMenu {
   
   public Scanner input = new Scanner(System.in);
   
    public static void showMainMenu() {

 		do {
		System.out.println("Choose")
        System.out.println("1. Create a character");
        System.out.println("2. Show Stats");
        System.out.println("3. Show Inventory");
        System.out.println("4. Visit Shop");
        System.out.println("5. Exit");
        inputMessager();
        int choice = input.nextInt();
       
        } (choice != 5);
    }
   
	public static void inputMessager() {
  		System.out.print("Enter your choice: ");
    } 
}

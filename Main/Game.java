package Main;

import Main.*;

public class Game {
    private int menu;

    Game() {
        menu = new GameMenu();
    }
   
    public void start() {
        System.out.println("Game Starting...");
		menu.showMainMenu();
    }
}
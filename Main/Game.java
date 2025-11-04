package Main;

public class Game {
    private int game;

    Gwme() {
        menu = new GameMenu();
    }
   
    public void start() {
        System.out.println("Game Starting...");
		menu.showMainMenu();
    }
}
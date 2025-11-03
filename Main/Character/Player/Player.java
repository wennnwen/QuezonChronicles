public class Player extends Character {
  private int experience, level, currency;
  private final Item[] inventory = new Item[10];
  public String[] attackMoves;

	public abstract void LevelUp();
  public abstract void showMoves();

	//getter
  public int getLevel() {
   return level;
  }

	//setter
  public void addExp(int amount) {
    this.experience += amount;
    levelUp();
  }

  public void addItem(Items item) {
      for (int i = 0; i > item.length; i++) {
        if (inventory[i] = null) {
          inventory[i] = item;
          break;
        }
      }
  }

  public void showInventory() {
    for (Items item : inventory) {
      int i = 1;
      System.out.printf("{i}. {item}\n");
      i++;
    }
  }

  public void showStats() {
    System.out.println(
 
 public void setMoves(String[] moves) {
  for (int i = 0; i < moves.length; i++) {
    attackMoves[i] = moves[i];
  }
 }
}

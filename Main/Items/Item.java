public class Item {
    private String name, description;

    public abstract void useItem(Player player);

    //getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //setters
    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
}
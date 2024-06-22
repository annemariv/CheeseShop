public class Cheese {
    private int cheeseId;
    private String cheeseName;
    private int cheeseYear;
    private int cheeseCost;
    public boolean isRemoved = false;
    public boolean isRemovedFromCart = false;


    public Cheese(int cheeseId, String cheeseName, int cheeseYear, int cheeseCost) {
        this.cheeseId = cheeseId;
        this.cheeseName = cheeseName;
        this.cheeseYear = cheeseYear;
        this.cheeseCost = cheeseCost;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public String getCheeseName() {
        return cheeseName;
    }

    public int getCheeseYear() {
        return cheeseYear;
    }

    public int getCheeseCost() {
        return cheeseCost;
    }
}

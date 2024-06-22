import java.util.ArrayList;

//shop manager actions
public class CheeseService {
    private ArrayList<Cheese> cheeses = new ArrayList<Cheese>();

    public ArrayList<Cheese>getCheese(){
        return cheeses;
    }
    public void addCheese(Cheese cheese){
        cheeses.add(cheese);
    }

    public void removeCheese(int cheeseId) {
        boolean removed = cheeses.removeIf(c -> c.getCheeseId() == cheeseId);
        if (removed) {
            System.out.println("Cheese removed successfully");
        } else {
            System.out.println("No cheese found with id: " + cheeseId);
        }
    }

    public void showAvailableCheese(){
        boolean isAvailable = false;
        for(Cheese cheese : cheeses){
            if(!cheese.isRemoved){
                System.out.println("Id: " + cheese.getCheeseId() + ", type: " + cheese.getCheeseName() +
                        ", year: " + cheese.getCheeseYear() + ", price: " + cheese.getCheeseCost() + "€");
                isAvailable = true;
            }
        }
        if(!isAvailable){
            System.out.println("Out of cheese!");
        }
    }
}

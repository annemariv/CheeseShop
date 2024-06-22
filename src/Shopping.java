import java.util.ArrayList;

//customer actions
public class Shopping {
    private ArrayList<Cheese> cart = new ArrayList<Cheese>();

    public void addToCart(Cheese cheese){
       cart.add(cheese);
    }

    public void addToCartName(String cheeseName){
        boolean cheeseFound = false;
        for(Cheese cheese : CheeseShop.cheeseService.getCheese()){
            if(cheese.getCheeseName().equals(cheeseName) && !cheese.isRemovedFromCart){
                addToCart(cheese);
                System.out.println("Cheese added to cart");
                cheeseFound=true;
                break;
            }
        } if(!cheeseFound){
            System.out.println("Cheese is not available");
        }
    }

    public void removeFromCartByName(String cheeseName) {
        boolean removed = cart.removeIf(c -> c.getCheeseName().equals(cheeseName));
        if (removed) {
            System.out.println("Cheese removed from cart");
        } else {
            System.out.println("Cheese " + cheeseName + " is not in cart");
        }
    }

    public int checkOut(){
        if(cart.isEmpty()){
            return 0;
        }
        int sum = 0;
        for(Cheese cheese : cart){
            if(!cheese.isRemovedFromCart){
                sum += cheese.getCheeseCost();
            }
        }
        return sum;
    }

    public void clearCart(){
        cart.clear();
    }

}

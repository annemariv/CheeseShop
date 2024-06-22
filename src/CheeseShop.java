import java.util.Scanner;

public class CheeseShop {
    public static CheeseService cheeseService = new CheeseService();
    public static Shopping shopping = new Shopping();
    public static Scanner scanner = new Scanner(System.in);
    public static Customer customer;

    public static void main(String[] args) {
        while(true){
            try{
                System.out.println("\nChoose your role 1 or 2 or exit: ");
                System.out.println("1 - shop manager");
                System.out.println("2 - customer");
                System.out.println("3 - exit the shop");
                var userInput = scanner.nextInt();

                if (userInput == 1) {
                    boolean shopManagerActions = true;
                    while(shopManagerActions){
                        System.out.println("\n1 - add new cheese to the shop");
                        System.out.println("2 - remove cheese from the shop");
                        System.out.println("3 - exit from the task selection");
                        var shopManager = scanner.nextInt();
                        switch (shopManager) {
                            case 1:
                                System.out.println("Cheese availability: ");
                                cheeseService.showAvailableCheese();
                                addCheese();
                                break;
                            case 2:
                                System.out.println("\nCheese availability: ");
                                cheeseService.showAvailableCheese();
                                removeCheese();
                                break;
                            case 3:
                                System.out.println("You exited from the task selection");
                                shopManagerActions = false;
                                break;
                            default:
                                System.out.println("Invalid selection. Please try again.");
                        }
                    }
                } else if (userInput == 2){
                    customer = new Customer();
                    customer.setCustomerId(123);
                    customer.setCustomerMoney(25);
                    System.out.println("\nWelcome to the cheese shop, customer no " + customer.getCustomerId() + "!" + "\nPlease choose what would you like to do: ");

                    boolean customerActions = true;
                    while(customerActions){
                        System.out.println("\n1 - show available cheese selection");
                        System.out.println("2 - add cheese to the cart");
                        System.out.println("3 - remove cheese from the cart");
                        System.out.println("4 - checkout/leave");
                        var customerInput = scanner.nextInt();
                        switch (customerInput){
                            case 1:
                                System.out.println("Current cheese selection: ");
                                cheeseService.showAvailableCheese();
                                break;
                            case 2:
                                addToCart();
                                break;
                            case 3:
                                removeFromCart();
                                break;
                            case 4:
                                checkOut();
                                customerActions = false;
                                break;
                            default:
                                System.out.println("Invalid selection, please try again.");
                        }
                    }
                } else if (userInput == 3){
                    System.out.println("You exited the shop!");
                    break;
                }else {
                    System.out.println("Invalid selection, please try again.");
                }
            } catch(Exception e){
                System.out.println("Wrong input!");
                scanner.nextLine();
            }
        }
    }
    public static void addCheese(){
        try{
            System.out.println("\nPlease enter the id of the cheese: ");
            int cheeseId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Please add the name of the cheese: ");
            String cheeseName = scanner.nextLine().toLowerCase();
            System.out.println("Please enter the year of the cheese: ");
            int cheeseYear = scanner.nextInt();
            System.out.println("Please enter the cheese price (€): ");
            int cheeseCost = scanner.nextInt();

            Cheese cheese = new Cheese(cheeseId, cheeseName, cheeseYear, cheeseCost);
            cheeseService.addCheese(cheese);
            System.out.println("Cheese added successfully");
        } catch(Exception e){
            System.out.println("Wrong input!");
            scanner.nextLine();
        }
    }
    public static void removeCheese(){
        try {
            System.out.println("\nPlease enter the cheese id you want to remove: ");
            int cheeseId = scanner.nextInt();
            scanner.nextLine();
            cheeseService.removeCheese(cheeseId);
        }catch(Exception e){
            System.out.println("Wrong input!");
            scanner.nextLine();
        }
    }
    public static void addToCart(){
        try{
            scanner.nextLine();
            System.out.println("\nPlease enter the name of the cheese you would like to add to the cart: ");
            String cheeseName = scanner.nextLine().toLowerCase();
            shopping.addToCartName(cheeseName);
        }catch(Exception e){
            System.out.println("Wrong input!");
            scanner.nextLine();
        }
    }
    public static void removeFromCart(){
        try{
            scanner.nextLine();
            System.out.println("Please enter the cheese name you want to remove from cart: ");
            String cheeseName = scanner.nextLine().toLowerCase();
            shopping.removeFromCartByName(cheeseName);
        }catch(Exception e){
            System.out.println("Wrong input!");
            scanner.nextLine();
        }
    }
    public static void checkOut(){
        int totalCost = shopping.checkOut();
        if(totalCost > 0){
            System.out.println("Total cost of the items: " + totalCost + "€");
            if(customer.canBuy(totalCost)){
                System.out.println("Purchase was successful");
                shopping.clearCart();
            } else{
                System.out.println("Not enough money");
                shopping.clearCart();
            }
        } else{
            System.out.println("Your cart is empty");
        }
    }
}
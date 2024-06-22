//customer
public class Customer {
    private int customerId;
    private int customerMoney;

    public Customer() {
        this.customerId = customerId;
        this.customerMoney = customerMoney;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerMoney(int customerMoney) {
        this.customerMoney = customerMoney;
    }

    public boolean canBuy(int totalCost){
        if(customerMoney >= totalCost){
            customerMoney -= totalCost;
            return true;
        } else{
            return false;
        }
    }

}

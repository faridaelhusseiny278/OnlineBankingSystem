public class Bill_Payment_test {
    String details;
    double price;
    Acc_Driver account;


    Bill_Payment_test(String details, double price, Acc_Driver account){
        this.details = details;
        this.price=price;
        this.account=account;
    }

    boolean payBill(){
        double available=account.getBalance();
        if(available>price){
           return true;
        }
        else{
            return false;
        }

    }

    public String getDetails(){
        return details;
    }
    public double getAmount(){
        return price;
    }




}

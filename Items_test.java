public class Items_test {
    String name;
    String id;
    double price;
    int count;


    public Items_test(String name, String id, double price, int count){
        this.name=name;
        this.id=id;
        this.price=price;
        this.count=count;
    }
    public void buy(){
        if(count>0) {
            count--;
        }
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

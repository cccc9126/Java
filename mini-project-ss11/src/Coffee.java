public class Coffee extends Drink{
    public boolean hasMilk;

    public Coffee(boolean hasMilk) {
        this.hasMilk = hasMilk;
    }

    public Coffee(int id, String name, int price, boolean hasMilk) {
        super(id, name, price);
        this.hasMilk = hasMilk;
    }

    @Override
    public double calculatePrice() {
        return hasMilk?price+5000:price;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(hasMilk?"Có sữa":"Đen đá");
    }

}

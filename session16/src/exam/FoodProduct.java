package exam;

public class FoodProduct extends Product {
    private double discountPercent;

    public FoodProduct(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public FoodProduct(String id, String name, double price, double discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }
    @Override
    double calculateFinalPrice(){
        return getPrice()*(1-this.discountPercent/100);
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Giảm "+ this.discountPercent/100+" %");
    }
}

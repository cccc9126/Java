public class FruitJuice extends Drink implements IMixable{
        public double discountPercent;

    public FruitJuice(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public FruitJuice(int id, String name, int price, double discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculatePrice() {
        return price*=1-discountPercent/100 ;
    }

    @Override
    public void mix() {
        System.out.println("Đang ép trái cây tươi...");
    }
}

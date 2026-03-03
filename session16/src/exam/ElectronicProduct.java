package exam;

public class ElectronicProduct extends Product{
    private int warrantyMonths;

    public ElectronicProduct(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    double calculateFinalPrice() {
        if(this.warrantyMonths>12){
            return getPrice()+1000000;
        }else{
            return getPrice();
        }
    }
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Tháng bảo hành: "+this.warrantyMonths);
    }
}

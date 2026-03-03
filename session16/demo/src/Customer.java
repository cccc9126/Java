public class Customer {
    private String customerId;
    private String name;
    private String phone;
    private double point;

    public Customer(String customerId, String name, String phone, double point) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.point = point;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", point=" + point +
                '}';
    }
}
package btth;

public class Ewallet extends PaymentMethod implements IPayable {
    private String phoneNumber;
    private double balance;

    public Ewallet(String accountName, String paymentId, String phoneNumber, double balance) {
        super(accountName, paymentId);
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    @Override
    public void validate() {
        if (!phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Số điện thoại không hợp lệ");
        }
    }

    @Override
    public void pay(double amount) {
        validate();
        if (amount > balance) {
            System.out.println("Số dư không đủ");
        } else {
            balance -= amount;
            System.out.println("Thanh toán " + amount + " bằng ví điện tử. Số dư còn lại: " + balance);
        }
    }
}


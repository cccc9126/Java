package btth;

public class CreditCard extends PaymentMethod implements IPayable {
    private String cardNumber;
    private String cvv;
    private double creditLimit;

    public CreditCard(String accountName, String paymentId, String cardNumber, String cvv, double creditLimit) {
        super(accountName, paymentId);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
    }

    @Override
    public void validate() {
        if (!cardNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Số thẻ không hợp lệ");
        }
        if (cvv.length() != 3) {
            throw new IllegalArgumentException("CVV không hợp lệ");
        }
    }

    @Override
    public void pay(double amount) {
        validate();
        if (amount > creditLimit) {
            System.out.println("Không đủ hạn mức tín dụng");
        } else {
            creditLimit -= amount;
            System.out.println("Thanh toán " + amount + " bằng thẻ tín dụng. Hạn mức còn lại: " + creditLimit);
        }
    }
}


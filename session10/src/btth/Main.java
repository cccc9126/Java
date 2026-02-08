package btth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name, id, cardNumber, cvv, phone;
        double limit, balance, amount;

        do {
            System.out.print("Nhập tên chủ thẻ: ");
            name = sc.nextLine();
        } while (name.isEmpty());

        do {
            System.out.print("Nhập mã thanh toán: ");
            id = sc.nextLine();
        } while (id.isEmpty());

        do {
            System.out.print("Nhập số thẻ (16 chữ số): ");
            cardNumber = sc.nextLine();
        } while (!cardNumber.matches("\\d{16}"));

        do {
            System.out.print("Nhập CVV (3 chữ số): ");
            cvv = sc.nextLine();
        } while (!cvv.matches("\\d{3}"));

        do {
            System.out.print("Nhập hạn mức tín dụng: ");
            limit = sc.nextDouble();
        } while (limit <= 0);

        sc.nextLine();

        IPayable creditCard = new CreditCard(name, id, cardNumber, cvv, limit);

        do {
            System.out.print("Nhập số điện thoại ví (10 chữ số): ");
            phone = sc.nextLine();
        } while (!phone.matches("\\d{10}"));

        do {
            System.out.print("Nhập số dư ví: ");
            balance = sc.nextDouble();
        } while (balance <= 0);

        IPayable eWallet = new Ewallet(name, "EW" + id, phone, balance);

        do {
            System.out.print("Nhập số tiền cần thanh toán bằng thẻ: ");
            amount = sc.nextDouble();
        } while (amount <= 0);

        creditCard.pay(amount);

        do {
            System.out.print("Nhập số tiền cần thanh toán bằng ví: ");
            amount = sc.nextDouble();
        } while (amount <= 0);

        eWallet.pay(amount);






    }
}

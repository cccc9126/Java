package bt6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Medicine> cart = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    updateQuantity();
                    break;
                case 3:
                    removeMedicine();
                    break;
                case 4:
                    printInvoice();
                    break;
                case 5:
                    findCheapMedicine();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }

        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n===== MENU KE DON =====");
        System.out.println("1. Them thuoc");
        System.out.println("2. Dieu chinh so luong");
        System.out.println("3. Xoa thuoc");
        System.out.println("4. In hoa don");
        System.out.println("5. Tim thuoc gia re (<50000)");
        System.out.println("0. Thoat");
        System.out.print("Chon: ");
    }

    private static Medicine findById(String id) {
        for (Medicine m : cart) {
            if (m.getDrugId().equalsIgnoreCase(id)) {
                return m;
            }
        }
        return null;
    }


    private static void addMedicine() {

        System.out.print("Nhap ma thuoc: ");
        String id = sc.nextLine();

        Medicine existing = findById(id);

        if (existing != null) {
            System.out.print("Thuoc da ton tai. Nhap so luong cong them: ");
            int qty = Integer.parseInt(sc.nextLine());
            existing.setQuantity(existing.getQuantity() + qty);
            System.out.println("Da cong don so luong");
            return;
        }

        System.out.print("Nhap ten thuoc: ");
        String name = sc.nextLine();

        System.out.print("Nhap gia: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so luong: ");
        int quantity = Integer.parseInt(sc.nextLine());

        cart.add(new Medicine(id, name, price, quantity));
        System.out.println("Them thuoc thanh cong");
    }


    private static void updateQuantity() {

        while (true) {
            System.out.print("Nhap ma thuoc: ");
            String id = sc.nextLine();

            Medicine m = findById(id);

            if (m == null) {
                System.out.println("Khong tim thay thuoc. Nhap lai!");
            } else {
                System.out.print("Nhap so luong moi: ");
                int newQty = Integer.parseInt(sc.nextLine());

                if (newQty == 0) {
                    cart.remove(m);
                    System.out.println("Thuoc da bi xoa");
                } else {
                    m.setQuantity(newQty);
                    System.out.println("Cap nhat thanh cong");
                }
                break;
            }
        }
    }


    private static void removeMedicine() {

        System.out.print("Nhap ma thuoc can xoa: ");
        String id = sc.nextLine();

        Medicine m = findById(id);

        if (m == null) {
            System.out.println("Khong tim thay thuoc");
            return;
        }

        cart.remove(m);
        System.out.println("Xoa thanh cong");
    }


    private static void printInvoice() {

        if (cart.isEmpty()) {
            System.out.println("Don thuoc trong");
            return;
        }

        double total = 0;

        System.out.println("\n===== HOA DON =====");
        System.out.printf("%-10s %-20s %-10s %-10s %-15s\n",
                "Ma", "Ten", "Gia", "SL", "Thanh Tien");

        for (Medicine m : cart) {
            System.out.println(m);
            total += m.getTotalPrice();
        }

        System.out.println("----------------------------------------------");
        System.out.println("Tong tien: " + total + " VND");

        cart.clear(); // reset đơn
        System.out.println("Da reset don thuoc");
    }


    private static void findCheapMedicine() {

        boolean found = false;

        for (Medicine m : cart) {
            if (m.getUnitPrice() < 50000) {
                System.out.println(m);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong co thuoc gia duoi 50000");
        }
    }
}
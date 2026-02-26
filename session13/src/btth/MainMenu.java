package btth;

import java.util.Scanner;

public class MainMenu {

    private static Scanner sc = new Scanner(System.in);
    private static PatientManager manager = new PatientManager();

    public static void displayMenu() {
        System.out.println("\nQUAN LY BENH NHAN");
        System.out.println("1. Them benh nhan");
        System.out.println("2. Xoa benh nhan");
        System.out.println("3. Cap nhat benh nhan");
        System.out.println("4. Tim kiem benh nhan");
        System.out.println("5. Hien thi danh sach");
        System.out.println("0. Thoat");
        System.out.print("Chon: ");
    }

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    deletePatient();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    searchPatient();
                    break;
                case 5:
                    manager.displayPatients();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }

        } while (choice != 0);
    }

    private static void addPatient() {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Ten: ");
        String name = sc.nextLine();

        System.out.print("Tuoi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Gioi tinh: ");
        String gender = sc.nextLine();

        System.out.print("Benh: ");
        String disease = sc.nextLine();

        Patient p = new Patient(id, name, age, gender, disease);
        manager.addPatient(p);
    }

    private static void deletePatient() {
        System.out.print("Nhap ID can xoa: ");
        int id = Integer.parseInt(sc.nextLine());
        manager.removePatient(id);
    }

    private static void updatePatient() {
        System.out.print("Nhap ID can cap nhat: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Ten moi: ");
        String name = sc.nextLine();

        System.out.print("Tuoi moi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Gioi tinh moi: ");
        String gender = sc.nextLine();

        System.out.print("Benh moi: ");
        String disease = sc.nextLine();

        Patient updated = new Patient(id, name, age, gender, disease);
        manager.updatePatient(id, updated);
    }

    private static void searchPatient() {
        System.out.print("Nhap ten can tim: ");
        String name = sc.nextLine();
        manager.searchPatientByName(name);
    }
}

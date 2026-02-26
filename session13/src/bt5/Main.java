package bt5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Patient> patientList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    updateDiagnosis();
                    break;
                case 3:
                    dischargePatient();
                    break;
                case 4:
                    sortPatients();
                    displayPatients();
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
        System.out.println("\n===== QUAN LY BENH NHAN =====");
        System.out.println("1. Tiep nhan benh nhan");
        System.out.println("2. Cap nhat chan doan");
        System.out.println("3. Xuat vien");
        System.out.println("4. Sap xep danh sach");
        System.out.println("0. Thoat");
        System.out.print("Chon: ");
    }

    private static void addPatient() {

        System.out.print("Nhap ID: ");
        String id = sc.nextLine();

        if (findPatientById(id) != null) {
            System.out.println("ID da ton tai");
            return;
        }

        System.out.print("Nhap ten: ");
        String name = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap chan doan: ");
        String diagnosis = sc.nextLine();

        patientList.add(new Patient(id, name, age, diagnosis));
        System.out.println("Them thanh cong");
    }

    private static void updateDiagnosis() {

        System.out.print("Nhap ID can cap nhat: ");
        String id = sc.nextLine();

        Patient p = findPatientById(id);

        if (p == null) {
            System.out.println("Khong tim thay benh nhan");
            return;
        }

        System.out.print("Nhap chan doan moi: ");
        String newDiagnosis = sc.nextLine();
        p.setDiagnosis(newDiagnosis);

        System.out.println("Cap nhat thanh cong");
    }

    private static void dischargePatient() {

        System.out.print("Nhap ID can xoa: ");
        String id = sc.nextLine();

        Patient p = findPatientById(id);

        if (p == null) {
            System.out.println("Khong tim thay benh nhan");
            return;
        }

        patientList.remove(p);
        System.out.println("Xuat vien thanh cong");
    }

    private static Patient findPatientById(String id) {
        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    private static void sortPatients() {

        Collections.sort(patientList, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {

                if (p2.getAge() != p1.getAge()) {
                    return p2.getAge() - p1.getAge();
                }

                return p1.getFullName().compareTo(p2.getFullName());
            }
        });

        System.out.println("Da sap xep xong");
    }

    private static void displayPatients() {

        if (patientList.isEmpty()) {
            System.out.println("Danh sach trong");
            return;
        }

        for (Patient p : patientList) {
            System.out.println(p);
        }
    }
}

package btth;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalManagement hm = new HospitalManagement();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Đăng ký khám");
            System.out.println("2. Gọi khám");
            System.out.println("3. Xem hàng đợi");
            System.out.println("4. Tìm bệnh nhân");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Xem lịch sử");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tình trạng: ");
                    String condition = sc.nextLine();

                    System.out.print("Có phải cấp cứu? (y/n): ");
                    String type = sc.nextLine();

                    if (type.equalsIgnoreCase("y")) {
                        System.out.print("Mức độ ưu tiên: ");
                        int pr = sc.nextInt();
                        sc.nextLine();
                        hm.add(new EmergencyPatient(id, name, age, condition, pr));
                    } else {
                        hm.add(new Patient(id, name, age, condition));
                    }
                    break;

                case 2:
                    Patient p = hm.callNext();
                    if (p != null) {
                        System.out.println("Đang khám: ");
                        p.showInfo();
                        System.out.print("Nhập chẩn đoán/thuốc: ");
                        String record = sc.nextLine();
                        p.addHistory(record);
                    }
                    break;

                case 3:
                    hm.display();
                    break;

                case 4:
                    System.out.print("Nhập ID/Tên: ");
                    String key = sc.nextLine();
                    Patient found = hm.search(key);
                    if (found != null) found.showInfo();
                    else System.out.println("Không tìm thấy.");
                    break;

                case 5:
                    System.out.println("1. Theo tuổi");
                    System.out.println("2. Theo ưu tiên");
                    int opt = sc.nextInt();
                    sc.nextLine();
                    hm.sort(opt);
                    break;

                case 6:
                    System.out.print("Nhập ID bệnh nhân: ");
                    String pid = sc.nextLine();
                    Patient patient = hm.search(pid);
                    if (patient != null) patient.showHistory();
                    break;

                case 0:
                    return;
            }
        }
    }
}

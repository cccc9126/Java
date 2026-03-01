package btth;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientService service = new PatientService();
        int choice;

        do {
            System.out.println("\n========= QUẢN LÝ PHÒNG KHÁM =========");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Cập nhật bệnh nhân");
            System.out.println("3. Xóa bệnh nhân");
            System.out.println("4. Hiển thị danh sách bệnh nhân");
            System.out.println("5. Thêm hồ sơ khám bệnh");
            System.out.println("6. Xem hồ sơ theo bệnh nhân");
            System.out.println("7. Xóa hồ sơ khám");
            System.out.println("8. Tìm bệnh nhân");
            System.out.println("9. Sắp xếp bệnh nhân");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("SĐT: ");
                    String phone = sc.nextLine();

                    service.add(new Patient(id, name, age, phone));
                    break;

                case 2:
                    System.out.print("Nhập ID: ");
                    service.update(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Nhập ID: ");
                    service.delete(sc.nextLine());
                    break;

                case 4:
                    service.displayAll();
                    break;

                case 5:
                    System.out.print("Nhập ID bệnh nhân: ");
                    service.addRecord(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Nhập ID bệnh nhân: ");
                    service.viewRecords(sc.nextLine());
                    break;

                case 7:
                    System.out.print("ID bệnh nhân: ");
                    String pid = sc.nextLine();
                    System.out.print("ID hồ sơ: ");
                    String rid = sc.nextLine();
                    service.deleteRecord(pid, rid);
                    break;

                case 8:
                    System.out.print("1. Tìm theo ID | 2. Tìm theo tên: ");
                    int opt = Integer.parseInt(sc.nextLine());
                    if (opt == 1) {
                        service.searchById(sc.nextLine());
                    } else {
                        service.searchByName(sc.nextLine());
                    }
                    break;

                case 9:
                    System.out.println("1. Theo tên");
                    System.out.println("2. Theo tuổi");
                    System.out.println("3. Theo ID");
                    int s = Integer.parseInt(sc.nextLine());
                    if (s == 1) service.sortDefault();
                    else if (s == 2) service.sortByAge();
                    else service.sortById();
                    break;
            }

        } while (choice != 0);

        System.out.println("Bye bye.");
    }
}

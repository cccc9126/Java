import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentManager manager = new StudentManager(100);

    public static void main(String[] args) {
        int choice;
        do {
            menu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    manager.showAll();
                    break;
                case 2:
                    addStudentUI();
                    break;
                case 3:
                    findStudentUI();
                    break;
                case 4:
                    updateStudentUI();
                    break;
                case 5:
                    deleteStudentUI();
                    break;
                case 6:
                    sortUI();
                    break;
                case 7:
                    manager.thongKeXepLoai();
                    break;
                case 8:
                    manager.maxMinAvg();
                    System.out.println("Điểm trung bình chung: " + manager.avgAll());
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    static void menu() {
        System.out.println("\n====== MENU ======");
        System.out.println("1. Hiển thị danh sách");
        System.out.println("2. Thêm sinh viên");
        System.out.println("3. Tìm sinh viên");
        System.out.println("4. Cập nhật sinh viên");
        System.out.println("5. Xóa sinh viên");
        System.out.println("6. Sắp xếp");
        System.out.println("7. Thống kê xếp loại");
        System.out.println("8. Thống kê điểm");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");
    }

    static void addStudentUI() {
        System.out.print("Nhập mã: ");
        String id = sc.nextLine();
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập giới tính: ");
        String gender = sc.nextLine();
        double math = inputScore("Toán");
        double physics = inputScore("Lý");
        double chemistry = inputScore("Hóa");

        Student s = new Student(id, name, age, gender, math, physics, chemistry);
        if (manager.addStudent(s)) System.out.println("Thêm thành công.");
        else System.out.println("Thêm thất bại (trùng mã hoặc đầy danh sách).");
    }

    static void findStudentUI() {
        System.out.println("1. Tìm theo mã");
        System.out.println("2. Tìm theo tên");
        System.out.print("Chọn: ");
        int ch = Integer.parseInt(sc.nextLine());
        if (ch == 1) {
            System.out.print("Nhập mã: ");
            String id = sc.nextLine();
            Student s = manager.findById(id);
            if (s != null) s.hienThi();
            else System.out.println("Không tìm thấy.");
        } else if (ch == 2) {
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            manager.findByName(name);
        }
    }

    static void updateStudentUI() {
        System.out.print("Nhập mã cần cập nhật: ");
        String id = sc.nextLine();
        System.out.print("Nhập tên mới: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi mới: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập giới tính mới: ");
        String gender = sc.nextLine();
        double math = inputScore("Toán");
        double physics = inputScore("Lý");
        double chemistry = inputScore("Hóa");

        if (manager.updateStudent(id, name, age, gender, math, physics, chemistry))
            System.out.println("Cập nhật thành công.");
        else
            System.out.println("Không tìm thấy sinh viên.");
    }

    static void deleteStudentUI() {
        System.out.print("Nhập mã cần xóa: ");
        String id = sc.nextLine();
        if (manager.deleteStudent(id)) System.out.println("Xóa thành công.");
        else System.out.println("Không tìm thấy sinh viên.");
    }

    static void sortUI() {
        System.out.println("1. Sắp xếp theo điểm TB giảm dần");
        System.out.println("2. Sắp xếp theo tên A-Z");
        System.out.print("Chọn: ");
        int ch = Integer.parseInt(sc.nextLine());
        if (ch == 1) {
            manager.sortByAvgDesc();
            System.out.println("Đã sắp xếp theo điểm.");
        } else if (ch == 2) {
            manager.sortByNameAZ();
            System.out.println("Đã sắp xếp theo tên.");
        }
    }

    static double inputScore(String subject) {
        double score;
        do {
            System.out.print("Nhập điểm " + subject + " (0-10): ");
            score = Double.parseDouble(sc.nextLine());
        } while (score < 0 || score > 10);
        return score;
    }
}

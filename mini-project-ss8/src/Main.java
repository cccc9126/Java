import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int current = 0; // số lượng sinh viên hiện có
        int choice;

        do {
            System.out.println("===== QUẢN LÝ ĐIỂM SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo Học lực");
            System.out.println("4. Sắp xếp theo học lực giảm dần");
            System.out.println("5. Thoát");
            System.out.println("==================================");
            System.out.print("Nhập lựa chọn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1-5!");
                continue;
            }

            switch (choice) {
                case 1:
                    current=addStudent(students,sc,current);
                    System.out.println(current);
                    break;
                case 2:
                    showStudents(students,current);
                    break;
                case 3:
                    searchByRank(sc,students,current);
                    break;
                case 4:
                    sort(students,current);
                    break;
                case 5:
                    System.out.println("Đang thoát chương trình...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (true);
    }

    public static int addStudent(Student[] students, Scanner sc, int current) {
        int amount;
        do {
            System.out.print("Nhập số lượng sinh viên muốn thêm: ");
            amount = Integer.parseInt(sc.nextLine());
            if (amount <= 0 || amount > 100) {
                System.out.println("Số lượng không hợp lệ");
            }
        } while (amount <= 0 || amount > 100);

        for (int i = 0; i < amount; i++) {
            String id;
            String name;
            double score;


            while (true) {
                System.out.print("Nhập mã sinh viên (VD: SV001): ");
                id = sc.nextLine();

                boolean check = id.matches("^SV\\d{3}$");
                if (!check) {
                    System.out.println("Mã sinh viên không đúng định dạng.");
                    continue;
                }


                boolean duplicate = false;
                for (int j = 0; j < current; j++) {
                    if (students[j] != null && students[j].getId().equals(id)) {
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate) {
                    System.out.println("Mã sinh viên đã tồn tại, vui lòng nhập mã khác.");
                } else {
                    break;
                }
            }

            System.out.print("Nhập tên sinh viên: ");
            name = sc.nextLine();

            do {
                System.out.print("Nhập điểm: ");
                score = Double.parseDouble(sc.nextLine());
                if (score < 0 || score > 10) {
                    System.out.println("Điểm không hợp lệ (0–10).");
                }
            } while (score < 0 || score > 10);

            students[current++] = new Student(id, name, score);
        }

        System.out.println("Thêm sinh viên thành công");
        return current;
    }

    public static void showStudents(Student[] students, int current) {
        if (current == 0) {
            System.out.println("Danh sách sinh viên đang trống.");
            return;
        }
        System.out.println("========= DANH SÁCH SINH VIÊN =========");
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|\n", "ID", "NAME", "SCORE","RANK");

        for (int i = 0; i < current; i++) {
            System.out.printf("|%-10s|%-10s|%-10f|%-10s|\n",
                    students[i].getId(),students[i].getName(),students[i].getScore(),students[i].getRank());
        }
        System.out.println("======================================");
    }

    public static void searchByRank(Scanner sc, Student[] students, int current) {
        if (current == 0) {
            System.out.println("Danh sách sinh viên đang trống.");
            return;
        }

        System.out.print("Nhập loại học lực cần tìm (Gioi/Kha/Trung Binh): ");
        String keyword = sc.nextLine();

        boolean found = false;
        System.out.println("Kết quả tìm kiếm:");
        for (int i = 0; i < current; i++) {
            if (students[i].getRank().equalsIgnoreCase(keyword)) {
                System.out.println(students[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào có học lực: " + keyword);
        }
    }

    public static void sort(Student[] students, int current) {
        for (int i = 0; i < current - 1; i++) {
            for (int j = 0; j < current - 1 - i; j++) {
                if (students[j].getScore() < students[j + 1].getScore()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }


}

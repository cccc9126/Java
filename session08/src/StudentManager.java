public class StudentManager {
    private Student[] students;
    private int size;

    public StudentManager(int capacity) {
        students = new Student[capacity];
        size = 0;
    }

    public boolean addStudent(Student s) {
        if (size >= students.length) return false;
        if (findById(s.getId()) != null) return false;
        students[size++] = s;
        return true;
    }

    public void showAll() {
        if (size == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        printHeader();
        for (int i = 0; i < size; i++) {
            students[i].hienThi();
        }
    }
    public void printHeader() {
        System.out.printf("%-10s %-20s %-5s %-8s %-6s %-6s %-6s %-6s %-12s%n",
                "MaSV", "Ho Ten", "Tuoi", "GioiTinh", "Toan", "Ly", "Hoa", "DTB", "XepLoai");
        System.out.println("----------------------------------------------------------------------------------------");
    }

    public Student findById(String id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                return students[i];
            }
        }
        return null;
    }

    public void findByName(String name) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (students[i].getName().toLowerCase().contains(name.toLowerCase())) {
                students[i].hienThi();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên.");
        }
    }

    public boolean updateStudent(String id, String newName, int newAge, String newGender, double newMath, double newPhysics, double newChemistry) {
        Student s = findById(id);
        if (s == null) return false;
        s.setName(newName);
        s.setAge(newAge);
        s.setGender(newGender);
        s.setMath(newMath);
        s.setPhysics(newPhysics);
        s.setChemistry(newChemistry);
        return true;
    }

    public boolean deleteStudent(String id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < size - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--size] = null;
                return true;
            }
        }
        return false;
    }

    public void sortByAvgDesc() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (students[j].tinhDiemTB() < students[j + 1].tinhDiemTB()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public void sortByNameAZ() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (students[j].getName().compareToIgnoreCase(students[min].getName()) < 0) {
                    min = j;
                }
            }
            Student temp = students[min];
            students[min] = students[i];
            students[i] = temp;
        }
    }

    public void thongKeXepLoai() {
        int gioi = 0, kha = 0, tb = 0, yeu = 0;
        for (int i = 0; i < size; i++) {
            String xl = students[i].xepLoai();
            if (xl.equals("Giỏi")) gioi++;
            else if (xl.equals("Khá")) kha++;
            else if (xl.equals("Trung bình")) tb++;
            else yeu++;
        }
        System.out.println("Giỏi: " + gioi + ", Khá: " + kha + ", Trung bình: " + tb + ", Yếu: " + yeu);
    }

    public void maxMinAvg() {
        if (size == 0) return;
        Student max = students[0];
        Student min = students[0];
        for (int i = 1; i < size; i++) {
            if (students[i].tinhDiemTB() > max.tinhDiemTB()) max = students[i];
            if (students[i].tinhDiemTB() < min.tinhDiemTB()) min = students[i];
        }
        System.out.println("Sinh viên điểm cao nhất:");
        max.hienThi();
        System.out.println("Sinh viên điểm thấp nhất:");
        min.hienThi();
    }

    public double avgAll() {
        if (size == 0) return 0;
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += students[i].tinhDiemTB();
        }
        return sum / size;
    }
}

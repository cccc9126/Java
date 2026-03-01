package bt6;
import java.util.*;

class Patient {
    private String name;
    private int age;
    private String department;

    public Patient(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " (" + age + " tuổi)";
    }
}

 class HospitalGrouping {

    public static void main(String[] args) {

        List<Patient> patientList = Arrays.asList(
                new Patient("Lan", 30, "Tim mạch"),
                new Patient("Hùng", 40, "Nội tiết"),
                new Patient("Mai", 25, "Tim mạch")
        );

        Map<String, List<Patient>> departmentMap = new HashMap<>();

        for (Patient p : patientList) {
            departmentMap
                    .computeIfAbsent(p.getDepartment(), k -> new ArrayList<>())
                    .add(p);
        }

        System.out.println("Cấu trúc Map:");
        for (Map.Entry<String, List<Patient>> entry : departmentMap.entrySet()) {
            System.out.println("Khoa " + entry.getKey() + " -> " + entry.getValue());
        }

        String maxDept = "";
        int maxSize = 0;

        for (Map.Entry<String, List<Patient>> entry : departmentMap.entrySet()) {
            if (entry.getValue().size() > maxSize) {
                maxSize = entry.getValue().size();
                maxDept = entry.getKey();
            }
        }

        System.out.println("\nKhoa " + maxDept + " đang đông nhất (" + maxSize + " bệnh nhân)");
    }
}

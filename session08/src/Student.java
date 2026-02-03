public class Student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private double math;
    private double physics;
    private double chemistry;

    public Student(String id, String name, int age, String gender, double math, double physics, double chemistry) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double tinhDiemTB() {
        return (math + physics + chemistry) / 3;
    }

    public String xepLoai() {
        double avg = tinhDiemTB();
        if (avg >= 8) return "Giỏi";
        if (avg >= 6.5) return "Khá";
        if (avg >= 5) return "Trung bình";
        return "Yếu";
    }

    public void hienThi() {
        System.out.printf("%-10s %-20s %-5d %-8s %-6.2f %-6.2f %-6.2f %-6.2f %-12s%n",
                id, name, age, gender, math, physics, chemistry, tinhDiemTB(), xepLoai());
    }

}

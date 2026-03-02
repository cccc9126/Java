package bt5;

public class Patient {

    private String id;
    private String name;
    private int age;

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tên: " + name + " | Tuổi: " + age;
    }
}
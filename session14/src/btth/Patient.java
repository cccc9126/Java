package btth;

public class Patient extends Person implements Comparable<Patient> {

    private String phone;

    public Patient(String id, String name, int age, String phone) {
        super(id, name, age);
        this.phone = phone;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public int compareTo(Patient o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public void displayInfo() {
        System.out.println(id + " - " + name + " - " + age + " - " + phone);
    }

    // Quan trọng để không trùng ID trong Set
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Patient)) return false;
        Patient other = (Patient) obj;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

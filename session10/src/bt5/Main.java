package bt5;

public class Main {
    public static void main(String[] args) {
        Employee staff = new OfficeStaff("Huy", 8000);
        Employee manager = new Manager("Hiền", 12000, 3000);

        System.out.println(staff.name + " - Lương: " + staff.calculateSalary());
        System.out.println(manager.name + " - Lương: " + manager.calculateSalary());
    }
}


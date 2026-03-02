package bt4;

public class Main {
    public static void main(String[] args) {

        EmergencyQueue eq = new EmergencyQueue();

        eq.addPatient(new EmergencyPatient("E01", "Nguyen Van A", 2));
        eq.addPatient(new EmergencyPatient("E02", "Tran Thi B", 1));
        eq.addPatient(new EmergencyPatient("E03", "Le Van C", 2));
        eq.addPatient(new EmergencyPatient("E04", "Pham Van D", 1));

        System.out.println("Thứ tự khám dự kiến:");
        eq.displayQueue();

        System.out.println("\nGọi bệnh nhân:");
        System.out.println(eq.callNextPatient());

        System.out.println("\nSau khi gọi:");
        eq.displayQueue();
    }
}

package bt2;

public class Main {
    public static void main(String[] args) {

        PatientQueue pq = new PatientQueue();

        pq.addPatient(new Patient("P01", "Nguyen Van A", 25));
        pq.addPatient(new Patient("P02", "Tran Thi B", 30));
        pq.addPatient(new Patient("P03", "Le Van C", 40));

        System.out.println("Danh sách chờ:");
        pq.displayQueue();

        System.out.println("\nBệnh nhân tiếp theo:");
        System.out.println(pq.peekNextPatient());

        System.out.println("\nGọi khám:");
        System.out.println(pq.callNextPatient());

        System.out.println("\nSau khi gọi khám:");
        pq.displayQueue();
    }
}

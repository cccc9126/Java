package bt5;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        EmergencyCaseQueue queue = new EmergencyCaseQueue();

        Patient p1 = new Patient("E01", "Nguyen Van A", 30);
        Patient p2 = new Patient("E02", "Tran Thi B", 45);

        EmergencyCase case1 = new EmergencyCase(p1);
        EmergencyCase case2 = new EmergencyCase(p2);

        queue.addCase(case1);
        queue.addCase(case2);

        EmergencyCase current = queue.getNextCase();
        System.out.println("Đang xử lý: " + current.getPatient());

        current.addStep(new TreatmentStep("Tiếp nhận", LocalDateTime.now().toString()));
        current.addStep(new TreatmentStep("Chẩn đoán", LocalDateTime.now().toString()));
        current.addStep(new TreatmentStep("Điều trị", LocalDateTime.now().toString()));

        System.out.println("\nCác bước xử lý:");
        current.displaySteps();

        System.out.println("\nUndo bước:");
        System.out.println(current.undoStep());

        System.out.println("\nSau khi undo:");
        current.displaySteps();
    }
}

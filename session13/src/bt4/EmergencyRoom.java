package bt4;

import java.util.LinkedList;

public class EmergencyRoom {

    private LinkedList<String> queue = new LinkedList<>();

    public void patientCheckIn(String name) {
        queue.addLast(name);
    }

    public void emergencyCheckIn(String name) {
        queue.addFirst(name);
    }

    public void treatPatient() {
        if (queue.isEmpty()) {
            System.out.println("Khong con benh nhan nao");
            return;
        }

        String patient = queue.removeFirst();

        if (queue.isEmpty()) {
            System.out.println("Dang kham: " + patient);
        } else {
            System.out.println("Dang kham: " + patient);
        }
    }

    public static void main(String[] args) {

        EmergencyRoom er = new EmergencyRoom();

        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}

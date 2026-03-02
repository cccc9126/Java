package btth;

import java.util.*;

public class HospitalManagement implements IManagement<Patient> {

    private LinkedList<Patient> waitingQueue;

    public HospitalManagement() {
        waitingQueue = new LinkedList<>();
    }

    @Override
    public void add(Patient p) {
        if (p instanceof EmergencyPatient) {
            waitingQueue.addFirst(p);
        } else {
            waitingQueue.addLast(p);
        }
    }

    public Patient callNext() {
        if (waitingQueue.isEmpty()) return null;
        return waitingQueue.removeFirst();
    }

    @Override
    public void display() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Không có bệnh nhân chờ.");
            return;
        }
        for (Patient p : waitingQueue) {
            p.showInfo();
        }
    }

    @Override
    public Patient search(String keyword) {
        for (Patient p : waitingQueue) {
            if (p.getId().equalsIgnoreCase(keyword) ||
                    p.getFullName().equalsIgnoreCase(keyword)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void sort(int option) {
        if (option == 1) {
            waitingQueue.sort(Comparator.comparingInt(Patient::getAge));
        } else if (option == 2) {
            waitingQueue.sort((p1, p2) -> {
                if (p1 instanceof EmergencyPatient && p2 instanceof EmergencyPatient) {
                    return Integer.compare(
                            ((EmergencyPatient)p1).getPriorityLevel(),
                            ((EmergencyPatient)p2).getPriorityLevel()
                    );
                }
                if (p1 instanceof EmergencyPatient) return -1;
                if (p2 instanceof EmergencyPatient) return 1;
                return 0;
            });
        }
    }
}

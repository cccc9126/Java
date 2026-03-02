package bt2;

import java.util.LinkedList;
import java.util.Queue;

public class PatientQueue {

    private Queue<Patient> queue;

    public PatientQueue() {
        queue = new LinkedList<>();
    }

    public void addPatient(Patient p) {
        queue.offer(p);
    }

    public Patient callNextPatient() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    public Patient peekNextPatient() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Danh sách chờ trống.");
            return;
        }

        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}
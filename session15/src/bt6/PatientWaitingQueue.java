package bt6;

import java.util.LinkedList;
import java.util.Queue;

public class PatientWaitingQueue {

    private Queue<Patient> waitingQueue;
    private int totalPatients;

    public PatientWaitingQueue() {
        waitingQueue = new LinkedList<>();
        totalPatients = 0;
    }

    public void addPatient(Patient p) {
        waitingQueue.offer(p);
        totalPatients++;
    }

    public Patient callNext() {
        Patient p = waitingQueue.poll();
        if (p != null) {
            totalPatients--;
        }
        return p;
    }

    public int getTotalPatients() {
        return totalPatients;
    }
}

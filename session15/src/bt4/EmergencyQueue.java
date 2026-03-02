package bt4;

import java.util.PriorityQueue;

public class EmergencyQueue {

    private PriorityQueue<EmergencyPatient> queue;
    private long counter = 0;

    public EmergencyQueue() {
        queue = new PriorityQueue<>((p1, p2) -> {
            if (p1.getPriority() != p2.getPriority()) {
                return Integer.compare(p1.getPriority(), p2.getPriority());
            }
            return Long.compare(p1.getArrivalOrder(), p2.getArrivalOrder());
        });
    }

    public void addPatient(EmergencyPatient p) {
        p.setArrivalOrder(counter++);
        queue.offer(p);
    }

    public EmergencyPatient callNextPatient() {
        return queue.poll();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân đang chờ.");
            return;
        }

        PriorityQueue<EmergencyPatient> temp = new PriorityQueue<>(queue);

        while (!temp.isEmpty()) {
            System.out.println(temp.poll());
        }
    }
}
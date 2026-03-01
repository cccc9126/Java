package bt5;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Patient {
    private String name;
    private int severity;
    private int arrivalTime;

    public Patient(String name, int severity, int arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    public int getSeverity() {
        return severity;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return name + " (Mức " + severity + ", đến lúc " + arrivalTime + ")";
    }
}

 class EmergencyQueue {

    public static void main(String[] args) {

        Comparator<Patient> priorityComparator = (a, b) -> {
            if (a.getSeverity() != b.getSeverity()) {
                return Integer.compare(a.getSeverity(), b.getSeverity());
            }
            return Integer.compare(a.getArrivalTime(), b.getArrivalTime());
        };

        Set<Patient> queue = new TreeSet<>(priorityComparator);

        queue.add(new Patient("Bệnh nhân A", 3, 800));
        queue.add(new Patient("Bệnh nhân B", 1, 815));
        queue.add(new Patient("Bệnh nhân C", 1, 805));

        System.out.println("Thứ tự xử lý:");
        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}

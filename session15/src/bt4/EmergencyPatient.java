package bt4;

public class EmergencyPatient {

    private String id;
    private String name;
    private int priority;
    private long arrivalOrder;

    public EmergencyPatient(String id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public long getArrivalOrder() {
        return arrivalOrder;
    }

    public void setArrivalOrder(long arrivalOrder) {
        this.arrivalOrder = arrivalOrder;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tên: " + name + " | Mức độ: " +
                (priority == 1 ? "Cấp cứu" : "Thông thường");
    }
}

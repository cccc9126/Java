package bt6;

public class Ticket {

    private int ticketNumber;
    private String issuedTime;

    public Ticket(int ticketNumber, String issuedTime) {
        this.ticketNumber = ticketNumber;
        this.issuedTime = issuedTime;
    }

    @Override
    public String toString() {
        return "Số: " + ticketNumber + " | Thời gian: " + issuedTime;
    }
}

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EventID {

    private int eventID;
    private Booking booking;
    private Payment payment;
    private int progress;
    private boolean isDone;

    // private Complaint complaint;

    // private Queries queries;

    public EventID(Booking booking, Payment payment) {
        this.booking = booking;
        this.payment = payment;
        this.progress = 0;
        this.isDone = false;
        Random rand = new Random();
        this.eventID = rand.nextInt(1000000);
    }

    public EventID() {

    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    // public Complaint getComplaint() {
    //     return complaint;
    // }

    // public void setComplaint(Complaint complaint) {
    //     this.complaint = complaint;
    // }

    // public Queries getQueries() {
    //     return queries;
    // }

    // public void setQueries(Queries queries) {
    //     this.queries = queries;
    // }
}

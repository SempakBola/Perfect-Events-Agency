import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EventID {

    private int eventID;
    private Booking booking;
    private Payment payment;
    private boolean isDone;
    private Tracker tracker;
    private ArrayList<Changes> changes;


    public EventID(Booking booking, Payment payment) {
        this.booking = booking;
        this.payment = payment;
        this.tracker = new Tracker();
        this.isDone = false;
        Random rand = new Random();
        this.eventID = rand.nextInt(1000000);
        this.changes = new ArrayList<>();
    }

    public EventID() {

    }

    //getter and setter methods
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

    public ArrayList<Changes> getChanges() {
        return changes;
    }

    public void setChanges(ArrayList<Changes> changes) {
        this.changes = changes;
    }

    public void addChanges(Changes change){
            this.changes.add(change);
    }


    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Tracker getTracker() {
        return tracker;
    }

    //string method
    public void showAllChanges() {
        for (Changes change : this.changes) {
            change.str();
        }
    }

}

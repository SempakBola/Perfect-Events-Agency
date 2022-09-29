import java.util.Random;

public class EventID {
    private int eventID;
    private Booking booking;
    private Payment payment;
    private int progress;
    private boolean isDone;

    public EventID(Booking booking, Payment payment) {
        Random rand = new Random();
        this.eventID = rand.nextInt(10000);
        this.booking = booking;
        this.payment = payment;
        this.progress = 0;
        this.isDone = false;
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

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    
}

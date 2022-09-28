import java.util.Random;
public class Payment {
    private String paymentMethod;
    private float amount;

    public Payment(String paymentMethod, float amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }
    //getter and setter methods
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void createEventID(Booking booking, Payment payment, int progress, boolean isDone) {
        //create event ID
        Random rand = new Random();
        int id = rand.nextInt(1000);
        EventID eventID = new EventID(id,booking,payment,progress,isDone);
    }
}

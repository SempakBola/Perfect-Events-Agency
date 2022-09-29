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

    public EventID createEventID(Customer customer,Booking booking, Payment payment) {
        customer.setBalance(customer.getBalance() - payment.getAmount());
        //create event ID
        EventID eventID = new EventID(booking,payment);
        return eventID;
    }
}

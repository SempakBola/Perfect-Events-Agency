import java.util.Random;
public class Payment {
    private String paymentMethod;
    private double amount;

    public Payment(String paymentMethod, double amount) {
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public EventID createEventID(Customer customer,Booking booking, Payment payment) {
        customer.setBalance((float) (customer.getBalance() - payment.getAmount()));
        //create event ID
        EventID eventID = new EventID(booking,payment);
        return eventID;
    }
}

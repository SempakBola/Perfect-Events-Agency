import java.util.*;
public class Customer{
    
    private String firstName;
    private String lastName;
    private String dob;
    private String address;

    //for testing purposes only
    private float balance;

    private ArrayList<Complaint> complaints;
    private ArrayList<Refund> refunds;
    private ArrayList<EventID> events;
    private ArrayList<Queries> queries;

    public Customer(){
        this.balance=1000;
        this.complaints = new ArrayList<Complaint>();
        this.refunds = new ArrayList<Refund>();
        this.events = new ArrayList<EventID>();
        this.queries = new ArrayList<Queries>();
    };

    public Customer(String firstName, String lastName, String dob, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.balance=1000;
        this.complaints = new ArrayList<Complaint>();
        this.refunds = new ArrayList<Refund>();
        this.events = new ArrayList<EventID>();
        this.queries = new ArrayList<Queries>();
    }

    //getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Complaint> getComplaints() {
        return complaints;
    }

    public ArrayList<Refund> getRefunds() {
        return refunds;
    }

    public ArrayList<EventID> getEvents() {
        return events;
    }

    public ArrayList<Queries> getQueries() {
        return queries;
    }

    public float getBalance() {
        return balance;
    }

    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    //adders
    public void addComplaint(Complaint complaint) {
        this.complaints.add(complaint);
    }

    public void addRefund(Refund refund) {
        this.refunds.add(refund);
    }

    public void addEvent(EventID event) {
        this.events.add(event);
    }

    public void addQuery(Queries query) {
        this.queries.add(query);
    }

    //create query
    public void createQuery(String details) {
        Queries query = new Queries(details);
        this.queries.add(query);
    }

    //view queries
    public void viewQueries() {
        for (Queries query : queries) {
            System.out.println("Query ID: " + query.getQueryID());
            System.out.println("Details: " + query.getDetails());
            System.out.println("Reply: " + query.getReply());
        }
    }

    //view events
    public void viewEvents() {
        for (EventID event : events) {
            System.out.println("Event ID: " + event.getEventID());
            System.out.println("Payment Method: " + event.getPayment().getPaymentMethod());
            System.out.println("Amount Paid: " + event.getPayment().getAmount());
            event.getBooking().str();
        }
    }

    // view packages
    public void viewPackage(Packages selectedPackage) {
        System.out.println(selectedPackage.getDetails());
        System.out.println(selectedPackage.getPrice());
    }

    //view venues
    public void viewVenue(Venue selectedVenue) {
        System.out.println(selectedVenue.getName());
        System.out.println(selectedVenue.getPrice());
        System.out.println(selectedVenue.getCapacity());
        System.out.println(selectedVenue.isAvailability());
    }

    //view food Selection
    public void viewFood(FoodSelection selectedFood) {
        System.out.println(selectedFood.getFoodandBeveragePackage());
        System.out.println(selectedFood.getPrice());
    }

    public void createBooking(Customer customer,Booking booking, String paymentMethod) {
        events.add(booking.createPayment(customer, paymentMethod, booking));
    }

    public int checkProgress(EventID event) {
        return event.getProgress();
    }

    public void requestRefund(Customer customer,EventID eventID, String details) {
        Refund refund = new Refund(eventID, details);
        refund.refundMoney(customer, eventID.getEventID());
        refunds.add(refund);
    }

    public void makeComplaint(EventID event, String details) {
        Complaint complaint = new Complaint(event, details);
        complaints.add(complaint);
    }


    public float checkBalance() {
        return balance;
    }


    public void changeBooking(Customer customer, int eventID,Booking booking, String paymentMethod) {
        //loop through the list and look for the matching eventID
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getEventID()==eventID){
                //if found, refund the payment
                setBalance((float) events.get(i).getPayment().getAmount()+getBalance());
                //create new booking
                createBooking(customer, booking, paymentMethod);
                //remove old booking
                events.remove(i);
            }
            else{
                System.out.println("Event not found");
            }
        }
    }

    public void customerDetails(){
        System.out.println("Customer: "+firstName+" "+lastName);
        System.out.println("DOB: "+dob);
        System.out.println("Address: "+address);
        System.out.println("Balance: "+balance);

    }
}
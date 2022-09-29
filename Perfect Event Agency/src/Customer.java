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

    public Customer(){};

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
        Random rand = new Random();
        int queryID= rand.nextInt(1000);
        String reply=" ";
        Queries query = new Queries(queryID, details, reply);
        this.queries.add(query);
    }

    // view packages
    public void viewPackage(Packages selectedPackage) {
        System.out.println(selectedPackage.getDetails());
        System.out.println(selectedPackage.getPrice());
    }

    public void createBooking(Customer customer,Packages selectedPackage, Venue selectedVenue, FoodSelection selectedFood, Options selectedOptions, String paymentMethod) {
        Booking booking = new Booking(selectedPackage, selectedVenue, selectedFood, selectedOptions);
        events.add(booking.createPayment(customer, paymentMethod, booking));
    }

    public int checkProgress(EventID event) {
        return event.getProgress();
    }

    public void requestRefund(EventID event, String details) {
        Refund refund = new Refund(event, details);
        refunds.add(refund);
    }

    public void makeComplaint(EventID event, String details) {
        Complaint complaint = new Complaint(event, details);
        complaints.add(complaint);
    }

    public void changeBooking(Customer customer, int eventID,Packages packages, Venue venue, FoodSelection foodSelection, Options options, String paymentMethod) {
        //loop through the list and look for the matching eventID
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getEventID()==eventID){
                //if found, refund the payment
                setBalance((float) events.get(i).getPayment().getAmount());
                //create new booking
                createBooking(customer, packages,venue,foodSelection,options, paymentMethod);
                //remove old booking
                events.remove(i);
            }
            else{
                System.out.println("Event not found");
            }
        }
    }
}
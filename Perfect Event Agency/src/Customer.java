import java.util.*;
public class Customer{
    
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
    private ArrayList<Complaint> complaints;
    private ArrayList<Refund> refunds;
    private ArrayList<EventID> events;
    private ArrayList<Queries> queries;

    public Customer(String firstName, String lastName, String dob, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
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

    public void viewPackage(Packages package){

    }

}
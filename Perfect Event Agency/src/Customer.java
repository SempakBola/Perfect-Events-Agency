import java.util.*;
public class Customer{
    
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
    private int phoneNumber;

    //for testing purposes only
    private float balance;

    private ArrayList<Complaint> complaints;
    private ArrayList<Refund> refunds;
    private ArrayList<EventID> events;
    private ArrayList<Queries> queries;
    private ArrayList<Inspection> inspections;

    public Customer(){
        this.balance=1000;
        this.complaints = new ArrayList<Complaint>();
        this.refunds = new ArrayList<Refund>();
        this.events = new ArrayList<EventID>();
        this.queries = new ArrayList<Queries>();
        this.inspections = new ArrayList<Inspection>();
    };

    public Customer(String firstName, String lastName, String dob, String address, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance=1000;
        this.complaints = new ArrayList<Complaint>();
        this.refunds = new ArrayList<Refund>();
        this.events = new ArrayList<EventID>();
        this.queries = new ArrayList<Queries>();
        this.inspections = new ArrayList<Inspection>();
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

    public ArrayList<Inspection> getInspections() {
        return inspections;
    }

    public int getPhoneNumber() {
        return phoneNumber;
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

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public void addInspection(Inspection inspection) {
        this.inspections.add(inspection);
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

    //view refunds
    public void viewRefunds() {
        for (Refund refund : refunds) {
            System.out.println("Event ID: " + refund.getEventID().getEventID());
            System.out.println("Details: " + refund.getDetails());
            System.out.println("Is Refunded: " + refund.isIsRefunded());
        }
    }

    //view events
    public boolean viewEvents() {
        boolean isThereEvents= false;
        if (events.size()==0){
            System.out.println("You don't have any events booked yet.");
        }

        else{
            for (EventID event : events) {
                System.out.println("Event ID: " + event.getEventID());
                event.getPayment().str();
                event.getBooking().str();
                event.getTracker().checkProgress(event.getEventID());

                System.out.println("----------------");
                isThereEvents=true;
            }
        }
        return isThereEvents;
        
    }

    // view packages
    public void viewPackages(ArrayList<Packages>packages){
        for (Packages pack : packages) {
            pack.str();
            System.out.println("----------------");
        }
    }

    //view venues
    public void showAvailableVenues(ArrayList<Venue> venues, Booking booking) {
        for (Venue venue : venues) {
            if (venue.getCapacity() >= booking.getPackages().getCapacity() && venue.isAvailability()==true) {
                venue.str();
            }
        }
    }
    //view food Selection
    public void viewFood(ArrayList<FoodSelection> food) {
        for (FoodSelection f : food) {
            f.str();
        }
    }

    //get eventID
    public EventID getEventByID(int number) {
        for (EventID eventID : events) {
            if (eventID.getEventID() == number) {
                return eventID;
            }
        }
        return null;
    }

    

    //view all venues
    public void viewAllVenues(ArrayList<Venue> venues) {
        for (Venue venue : venues) {
            venue.str();
        }
    }

    public void createBooking(Customer customer,Booking booking, String paymentMethod, String firstName, String lastName, String dob,
    String address, int phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setDob(dob);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        events.add(booking.createPayment(customer, paymentMethod, booking));
    }


    public void requestRefund(Customer customer,EventID eventID, String details) {
        Refund refund = new Refund(eventID, details);
        //testing if refund function works
        refund.refundMoney(customer, eventID.getEventID());
        System.out.println("Your balance is now: " + customer.getBalance());
        
        refunds.add(refund);
    }

    public void makeComplaint(int eventID, String details) {
        viewEvents();
        for (EventID e : events) {
            if (e.getEventID() == eventID) {
                Complaint complaint = new Complaint(e, details);
                complaints.add(complaint);
            }
        }
    }

    public void viewComplaints() {
        for (Complaint complaint : complaints) {
            System.out.println("Event ID: " + complaint.getEventID().getEventID());
            System.out.println("Details: " + complaint.getDetails());
            System.out.println("Reply: " + complaint.getReply());
        }
    }

    public float checkBalance() {
        return balance;
    }

    public void bookInspection( ArrayList<Venue> venues, int venueID) {
        for (Venue venue: venues){
            if (venue.getVenueID()==venueID){
                venue.showInspectionDateandTime();
                System.out.println("Select the date you want to book(enter the number): ");
                Scanner sc = new Scanner(System.in);
                int dateNum = sc.nextInt()-1;
                String date= venue.getAvailableDatesForInspection().get(dateNum);
                System.out.println("Select the time you want to book(enter the number): ");
                int timeNum = sc.nextInt()-1;
                String time= venue.getAvailableTimesForInspection().get(timeNum);

                Inspection inspection = new Inspection(date, time, venue);
                inspections.add(inspection);
            }
        }
    }



    public void changeBooking(int eventID, ArrayList<FoodSelection> foodSelections){
        System.out.println("You can only change the options and the food selection.");
        viewEvents();
        Scanner sc = new Scanner(System.in);
        Changes change = new Changes(eventID);
        
        for (EventID e : getEvents()) {
            double currentPayment = e.getPayment().getAmount();
            double currentFoodPrice =e.getBooking().getFoodSelection().getPrice();
            Options currentOption = e.getBooking().getOptions();
            FoodSelection currentFood = e.getBooking().getFoodSelection();
            change.setOldFoodSelection(currentFood);
            change.setOldOptions(currentOption);
            if (e.getEventID() == eventID) {
                System.out.println("Here are the details of your booking: ");
                e.getBooking().str();
                System.out.println("Do you want to change the food selection? (Enter the number) \n1.Yes \n2.No  ");
                int foodSelection = sc.nextInt();
                if(foodSelection==1){
                    change.setFoodSelectionChanged(true);
                    System.out.println("Here are the available food options: ");
                    viewFood(foodSelections);
                    System.out.println("------------------");
                    System.out.println("Enter the number of the foodSelection that you want: ");
                    int selection = sc.nextInt();
                    e.getBooking().SelectFood(foodSelections, selection);
                    double newFoodPrice = e.getBooking().getFoodSelection().getPrice();
                    e.getBooking().changeFoodPrice(newFoodPrice, currentFoodPrice);
                
                }
                System.out.println("Do you want to change the optional services? (Enter the number) \n1.Yes \n2.No ");
                int optionalServices = sc.nextInt();
                if(optionalServices==1){
                    change.setOptionalServicesChanged(true);
                    Scanner sc5 = new Scanner(System.in);
                    int subchoice10;
                    do {
                        System.out.println("Here are the optional services that you chose: ");
                        e.getBooking().getOptions().str();
                        System.out.println("What changes would you like to make for the optional services? ");
                        System.out.println("1. Change flower decorations ");
                        System.out.println("2. Change musical band ");
                        System.out.println("3. Change sound system ");
                        System.out.println("4. Back ");
                        subchoice10=sc5.nextInt();
                        switch (subchoice10) {
                            case 1:
                                if (e.getBooking().getOptions().isIsFlowerDecoration()==false){
                                    e.getBooking().getOptions().setIsFlowerDecoration(true);
                                    System.out.println("Your flower decorations option is now set to true");
                                }
                                else {
                                    e.getBooking().getOptions().setIsFlowerDecoration(false);
                                    System.out.println("Your flower decorations option is now set to false ");
                                }
                                break;
                            case 2:
                                if (e.getBooking().getOptions().isIsHireBand()==false){
                                    e.getBooking().getOptions().setIsHireBand(true);
                                    System.out.println("Your MusicalBand option is now set to true");
                                }
                                else {
                                    e.getBooking().getOptions().setIsHireBand(false);
                                    System.out.println("Your MusicalBand option is now set to false ");
                                }
                                break;
            
                            case 3:
            
                                if (e.getBooking().getOptions().isIsSoundSystem()==false){
                                    e.getBooking().getOptions().setIsSoundSystem(true);
                                    System.out.println("Your SoundSystem option is now set to true");
                                }
                                else {
                                    e.getBooking().getOptions().setIsSoundSystem(false);
                                    System.out.println("Your SoundSystem option is now set to false ");
                                }
                                    break;
            
                            default:
                                break;
                        }
                        
                    } while (subchoice10!=4);
                
                }
                //compares the old price to the new price and adds it to the booking object
                double newPayment=e.getBooking().getTotalCost();
                FoodSelection newFood=e.getBooking().getFoodSelection();
                Options newOption=e.getBooking().getOptions();
                change.setNewFoodSelection(newFood);
                change.setNewOptions(newOption);
                double difference= newPayment-currentPayment;
                change.setPrice(difference);
                e.addChanges(change);
            }
        }
        
    }



    public void customerDetails(){
        System.out.println("Customer: "+firstName+" "+lastName);
        System.out.println("DOB: "+dob);
        System.out.println("Address: "+address);
        System.out.println("Balance: "+balance);
        System.out.println("-------------------------");
        System.out.println("EVENTS");
        viewEvents();
        System.out.println("-------------------------");
        System.out.println("COMPLAINTS");
        viewComplaints();
        System.out.println("-------------------------");
        System.out.println("QUERIES");
        viewQueries();
        System.out.println("-------------------------");
        System.out.println("REFUNDS");
        viewRefunds();

    }
}
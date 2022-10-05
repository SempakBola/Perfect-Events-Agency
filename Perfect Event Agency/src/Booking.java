import java.util.ArrayList;

public class Booking {
    private Packages packages;
    private Venue venue;
    private FoodSelection foodSelection;
    private Options options;
    private double totalCost;
    private int attendees;


    public Booking() {
        this.totalCost = 0;
    };

    public Booking(Packages packages, Venue venue, FoodSelection foodSelection, Options options, int attendees) {
        this.packages = packages;
        this.venue = venue;
        this.foodSelection = foodSelection;
        this.options = options;
        this.totalCost = 0;
        this.attendees = attendees;

    }

    //getter and setter methods
    public Packages getPackages() {
        return packages;
    }

    public void selectPackage(ArrayList<Packages> packagesList, int package_num) {
        for (Packages p : packagesList) {
            if (p.getPackage_num() == package_num) {
                this.packages = p;
            }
        }

    }

    public Venue getVenue() {
        return venue;
    }

    public void selectVenue(ArrayList<Venue> venueList, String venueName) {
        this.venue = venue;
        this.totalCost += venue.getPrice();

    }

    public FoodSelection getFoodSelection() {
        return foodSelection;
    }

    public void foodSelection(FoodSelection foodSelection) {
       this.foodSelection = foodSelection;
        this.totalCost+=foodSelection.getPrice();

    }

    public Options getOptions() {
        return options;
    }

    public void selectOptions(Options options) {
        this.options = options;
        this.totalCost+=options.OptionCost();

    }

    public double getTotalCost() {
        return totalCost;
    }


    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public EventID createPayment(Customer customer, String paymentMethod, Booking booking) {
        //create payment
        Payment payment = new Payment(paymentMethod, booking.getTotalCost());
        //create eventID
        return payment.createEventID(customer, booking, payment);
    }


    public void str(){
        packages.str();
        System.out.println("Number of Attendees: " + getAttendees());
        System.out.println("Venue: " + venue.getName());
        System.out.println("Food: " + foodSelection.getFoodandBeveragePackage());
        System.out.println("Options: " + options.toString());
        System.out.println("Total Cost: " + totalCost);
    }

}

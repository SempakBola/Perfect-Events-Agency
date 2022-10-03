import java.util.ArrayList;

public class Booking {
    private Packages packages;
    private Venue venue;
    private FoodSelection foodSelection;
    private Options options;
    private double totalCost;


    public Booking() {
        this.totalCost = 0;
    };

    public Booking(Packages packages, Venue venue, FoodSelection foodSelection, Options options) {
        this.packages = packages;
        this.venue = venue;
        this.foodSelection = foodSelection;
        this.options = options;
        this.totalCost = 0;

    }

    //getter and setter methods
    public Packages getPackages() {
        return packages;
    }

    public void selectPackage(Packages selection) {
        this.packages = selection;
        this.totalCost += selection.getPrice();

    }

    public Venue getVenue() {
        return venue;
    }

    public void selectVenue(Venue venue) {
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
        System.out.println("Package: " + packages.str(););
        System.out.println("Venue: " + venue.getName());
        System.out.println("Food: " + foodSelection.getFoodandBeveragePackage());
        System.out.println("Options: " + options.toString());
        System.out.println("Total Cost: " + totalCost);
    }

}

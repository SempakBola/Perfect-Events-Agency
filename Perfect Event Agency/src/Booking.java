import java.util.ArrayList;

public class Booking {
    private Packages packages;
    private Venue venue;
    private FoodSelection foodSelection;
    private Options options;
    private double totalCost;
    private int attendees;
    private double serviceFee;


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

    //selects the package from a list of packages and sets the package in the booking
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

    //selects the venue from a list of venues and sets the venue in the booking and updates the total cost
    public void selectVenue(ArrayList<Venue> venueList, int venueID) {
        for (Venue v : venueList) {
            if (v.getVenueID() == venueID) {
                this.venue = v;
                this.totalCost += v.getPrice();
            }
        }
        

    }

    public FoodSelection getFoodSelection() {
        return foodSelection;
    }

    // selects the food from a list of food and sets the food in the booking
    public void SelectFood(ArrayList<FoodSelection> foodSelection, int foodID) {
        for (FoodSelection f : foodSelection) {
            if (f.getFoodID() == foodID) {
                this.foodSelection = f;
                this.totalCost += f.getPrice();
            }
        }

    }

    public Options getOptions() {
        return options;
    }

    // select the options and adds the total cost of the options to the booking
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

    //deducting the current food price from the total price (used in the changes)
    public void removeFoodPrice(double currentFoodPrice) {
        this.totalCost -= currentFoodPrice;
    }

    //making the payment and generating the event id
    public EventID createPayment(Customer customer, String paymentMethod, Booking booking) {
        //create payment
        Payment payment = new Payment(paymentMethod, getTotalCost());
        //create eventID
        return payment.createEventID(customer, booking, payment);
    }
    //charging the service fee by adding the fixed base fee and percentage fee of the booking to the total cost
    public double ServiceFee(){
        double baseFee = 500.00;
        double fee = baseFee + (venue.getPrice()+foodSelection.getPrice()+options.OptionCost()) *0.1;
        this.totalCost += fee;
        return fee;
    }
    //setter for the service fee
    public void setServiceFee(double fee){
        this.serviceFee = fee;
    }
    //getter for the service fee
    public double getServiceFee(){
        return this.serviceFee;
    }



    public void str(){
        packages.str();
        System.out.println("Number of Attendees: " + getAttendees());
        System.out.println("Venue: " + venue.getName());
        System.out.println("Food: " + foodSelection.getFoodandBeveragePackage());
        getOptions().str();
        System.out.println("Service Fee: " + getServiceFee());
        System.out.println("Total Cost: " + totalCost);
    }
}

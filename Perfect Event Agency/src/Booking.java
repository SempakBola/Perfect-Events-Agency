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

    public void changeFoodPrice(double newFoodPrice, double currentFoodPrice) {
        this.totalCost -= currentFoodPrice;
        this.totalCost += newFoodPrice;
    }

    public EventID createPayment(Customer customer, String paymentMethod, Booking booking) {
        //create payment
        Payment payment = new Payment(paymentMethod, booking.getTotalCost());
        //create eventID
        return payment.createEventID(customer, booking, payment);
    }

    public double ServiceFee(){
        double baseFee = 500.00;
        double fee = baseFee + (venue.getPrice()+foodSelection.getPrice()+options.OptionCost()) *0.1;
        this.totalCost += fee;
        return fee;
    }



    public void str(){
        packages.str();
        System.out.println("Number of Attendees: " + getAttendees());
        System.out.println("Venue: " + venue.getName());
        System.out.println("Food: " + foodSelection.getFoodandBeveragePackage());
        getOptions().str();
        System.out.println("Service Fee: " + ServiceFee());
        System.out.println("Total Cost: " + totalCost);
    }
}

public class Booking {
    private Packages packages;
    private Venue venue;
    private FoodSelection foodSelection;
    private Options options;
    private int totalCost;

    public Booking() {
    };

    public Booking(Packages packages, Venue venue, FoodSelection foodSelection, Options options, int totalCost) {
        this.packages = packages;
        this.venue = venue;
        this.foodSelection = foodSelection;
        this.options = options;
        this.totalCost = totalCost;
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

    public Options selectOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void createPayment(String paymentMethod, Booking booking, int progress, boolean isDone) {
        //create payment
        Payment payment = new Payment(paymentMethod, totalCost);
        //create eventID
        payment.createEventID(booking, payment, progress, isDone);
    }

}

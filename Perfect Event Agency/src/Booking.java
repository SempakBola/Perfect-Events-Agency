public class Booking {
    private Package packages;
    private Venue venue;
    private FoodSelection foodSelection;
    private Options options;
    private int totalCost;

    public Booking(Package packages, Venue venue, FoodSelection foodSelection, Options options, int totalCost) {
        this.packages = packages;
        this.venue = venue;
        this.foodSelection = foodSelection;
        this.options = options;
        this.totalCost = totalCost;
    }

    //getter and setter methods
    public Package getPackages() {
        return packages;
    }

    public void setPackages(Package packages) {
        this.packages = packages;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public FoodSelection getFoodSelection() {
        return foodSelection;
    }

    public void setFoodSelection(FoodSelection foodSelection) {
        this.foodSelection = foodSelection;
    }

    public Options getOptions() {
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

    public void createPayment(Booking booking, int progress, boolean isDone) {
        //create payment
        Payment payment = new Payment("Cash", totalCost);
        //create eventID
        payment.createEventID(booking, payment, progress, isDone);
    }

    public void foodSelection(){

    }

    public void venueSelection(){
        
    }

    public void selectOptions(){

    }

}

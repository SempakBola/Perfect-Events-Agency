public class Changes {
    private int eventID;
    private boolean isFoodSelectionChanged;
    private boolean isOptionalServicesChanged;
    private double paymentChanges;
    private FoodSelection oldFoodSelection;
    private Options oldOptions;
    private FoodSelection newFoodSelection;
    private Options newOptions;

    public Changes(int eventID) {
        this.isFoodSelectionChanged = false;
        this.isOptionalServicesChanged = false;
        this.eventID=eventID;
        this.paymentChanges = 0;
    }

    public Changes (int eventId,boolean isFoodSelectionChanged, boolean isOptionalServicesChanged) {
        this.eventID = eventId;
        this.isFoodSelectionChanged = isFoodSelectionChanged;
        this.isOptionalServicesChanged = isOptionalServicesChanged;
        this.paymentChanges = 0;
    }

    public int getEventID() {
        return eventID;
    }

    public boolean getIsFoodSelectionChanged() {
        return isFoodSelectionChanged;
    }

    public void setFoodSelectionChanged(boolean foodSelectionChanged) {
        isFoodSelectionChanged = foodSelectionChanged;
    }

    public boolean getIsOptionalServicesChanged() {
        return isOptionalServicesChanged;
    }

    public void setOptionalServicesChanged(boolean optionalServicesChanged) {
        isOptionalServicesChanged = optionalServicesChanged;
    }

    public double getPrice() {
        return paymentChanges;
    }

    public void setPrice(double price) {
        this.paymentChanges = price;
    }

    public FoodSelection getOldFoodSelection() {
        return oldFoodSelection;
    }

    public void setOldFoodSelection(FoodSelection oldFoodSelection) {
        this.oldFoodSelection = oldFoodSelection;
    }

    public Options getOldOptions() {
        return oldOptions;
    }

    public void setOldOptions(Options oldOptions) {
        this.oldOptions = oldOptions;
    }

    public FoodSelection getNewFoodSelection() {
        return newFoodSelection;
    }

    public void setNewFoodSelection(FoodSelection newFoodSelection) {
        this.newFoodSelection = newFoodSelection;
    }

    public Options getNewOptions() {
        return newOptions;
    }

    public void setNewOptions(Options newOptions) {
        this.newOptions = newOptions;
    }

    public void str(){
        System.out.println("Event ID: " + getEventID());
        System.out.println("Old Food Selection: ");
        getOldFoodSelection().str();
        System.out.println("New Food Selection: ");
        getNewFoodSelection().str();
        System.out.println("Old Optional Services: ");
        getOldOptions().str();
        System.out.println("New Optional Services: ");
        getNewOptions().str();
        System.out.println("Payment Changes: "+getPrice());
    }

}

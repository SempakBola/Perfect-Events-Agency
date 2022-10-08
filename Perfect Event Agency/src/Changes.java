public class Changes {
    private int eventID;
    private boolean isFoodSelectionChanged;
    private boolean isOptionalServicesChanged;
    private double paymentChanges;

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

}

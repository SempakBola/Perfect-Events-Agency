public class Refund {
    private EventID eventID;
    private String details;
    private boolean isRefunded;

    public Refund(EventID eventID, String details, boolean isRefunded) {
        this.eventID = eventID;
        this.details = details;
        this.isRefunded = isRefunded;
    }

    //getter and setter methods
    public EventID getEventID() {
        return eventID;
    }

    public void setEventID(EventID eventID) {
        this.eventID = eventID;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isIsRefunded() {
        return isRefunded;
    }

    public void setIsRefunded(boolean isRefunded) {
        this.isRefunded = isRefunded;
    }
}

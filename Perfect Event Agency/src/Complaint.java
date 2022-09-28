public class Complaint {
    private EventID eventID;
    private String details;
    private String reply;

    public Complaint(EventID eventID, String details, String reply) {
        this.eventID = eventID;
        this.details = details;
        this.reply = reply;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}

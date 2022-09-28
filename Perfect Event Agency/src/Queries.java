public class Queries {
    private int queryID;
    private String details;
    private String reply;

    public Queries(int queryID, String details, String reply) {
        this.queryID = queryID;
        this.details = details;
        this.reply = reply;
    }

    //getter and setter methods
    public int getQueryID() {
        return queryID;
    }

    public void setQueryID(int queryID) {
        this.queryID = queryID;
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

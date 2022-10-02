import java.util.Random;
public class Queries {
    private int queryID;
    private String details;
    private String reply;

    public Queries(String details) {
        this.queryID = new Random().nextInt(1000);
        this.details = details;
        this.reply = "";
    }

    public Queries() {

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

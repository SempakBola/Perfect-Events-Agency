import java.util.Random;

public class Inspection {
    private int inspectionID;
    private String inspectionDate;
    private String inspectionTime;
    private Venue venue;

    public Inspection( String inspectionDate, String inspectionTime, Venue venue) {
        this.inspectionID = new Random().nextInt(1000);
        this.inspectionDate = inspectionDate;
        this.inspectionTime = inspectionTime;
        this.venue = venue;
    }

    //getters

    public int getInspectionID() {
        return inspectionID;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public String getInspectionTime() {
        return inspectionTime;
    }

    public Venue getVenue() {
        return venue;
    }

    //setters

    public void setInspectionID(int inspectionID) {
        this.inspectionID = inspectionID;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public void setInspectionTime(String inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}

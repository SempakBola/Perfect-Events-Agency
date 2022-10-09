import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Cost_Plan {
    private int costPlanID;
    private EventID eventID;
    private Double revenue;
    private Double profit;
    private Double totalCost;

    Random rand = new Random();

    //constructor class for the cost plan class

    public Cost_Plan(EventID eventID) {
        this.costPlanID = rand.nextInt(100000);
        double totalcost = this.totalCost;
        double revenue = this.revenue;
        double profit = this.profit;
    }

    public Cost_Plan() { //empty constructor
    }

    //getters and setters for the cost plan class
    public int getCostPlanID() {
        return costPlanID;
    }

    public void setCostPlanID(int costPlanID) {
        this.costPlanID = costPlanID;
    }

    public EventID getEventID() {
        return eventID;
    }

    public void setEventID(EventID eventID) {
        this.eventID = eventID;
    }

    public double getRevenue(){ //revenue calc method that calculates revenue from the service fee
        this.revenue  = totalCost+ eventID.getBooking().ServiceFee();
        return  revenue;
    }
    public double getTotalCost(){ //based of the total cost in the booking class
        this.totalCost = eventID.getBooking().getTotalCost();
        return totalCost;
    }

    public double getProfit(){ //calc method. subtracts two other methods
        this.profit = getRevenue() - getTotalCost();
        return  profit;
    }



    //to string method
    @Override
    public String toString() {
        return "Cost_Plan{" +
                "costPlanID=" + costPlanID +
                ", eventID=" + eventID +
                ", revenue=" + revenue +
                ", profit=" + profit +
                ", totalCost=" + totalCost +
                ", rand=" + rand +
                '}';
    }
}

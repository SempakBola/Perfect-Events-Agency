public class Cost_Plan {
    private int costPlanID;
    private EventID eventID;
    private Double revenue;
    private Double profit;
    private Double totalCost;

    //constructor class for the cost plan class

    public Cost_Plan(int costPlanID, EventID eventID, Double revenue, Double profit, Double totalCost) {
        this.costPlanID = costPlanID;
        this.eventID = eventID;
        this.revenue = revenue;
        this.profit = profit;
        this.totalCost = totalCost;
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

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}

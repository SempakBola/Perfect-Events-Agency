import java.util.ArrayList;

public class Finance_Manager extends Employee {

   private ArrayList<Cost_Plan> costPlans = new ArrayList<>();

    private float workingEmployeeSplit;

    EventID eventID = new EventID();

    public Finance_Manager(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Finance_Manager");
    }

    public Finance_Manager() {
        super.setPosition("Finance_Manager");
    }

    public ArrayList<Cost_Plan> getCostPlans() {
        return costPlans;
    }

    public void changeCostPlan(ArrayList<Cost_Plan> costPlans) {
        this.costPlans = costPlans;
    }


    public float employeeDistribution(){
        Logistics_Manager log = new Logistics_Manager();
        if(log.optionalserviceused()){
            workingEmployeeSplit = 0.25F;
        }else{
            workingEmployeeSplit = 0.33F;
        }
        return workingEmployeeSplit;
    }

    public void allocateMoney(int employeeID){
        double amount = 0;
       for(Cost_Plan cost_plan: costPlans) {
           amount = cost_plan.getEventID().getBooking().ServiceFee() * employeeDistribution();

       }
        super.setEmployeeBalance(employeeID, amount);
    }

    public void paySalary(int employeeID){
        double amount = 0;
        for(Cost_Plan cost_plan: costPlans) {
            amount = cost_plan.getProfit() * employeeDistribution();

        }
        super.setSalary(employeeID,amount);
    }





}

import java.util.ArrayList;

public class Finance_Manager extends Employee { //finance manager class based of employee class

   private ArrayList<Cost_Plan> costPlans = new ArrayList<>();


   //constructor method
    public Finance_Manager(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Finance_Manager");
    }


    //empty constructor
    public Finance_Manager() {
        super.setPosition("Finance_Manager");
    }


    //getter and setter for the cost plan

    public ArrayList<Cost_Plan> getCostPlans() {
        return costPlans;
    }

    public void changeCostPlan(ArrayList<Cost_Plan> costPlans) {
        this.costPlans = costPlans;
    }


    //the amount allocation is based of how many employee are working. distribution is based of working employee, and it's equally distributed.
    public float employeeDistribution(){
        Logistics_Manager log = new Logistics_Manager();
        float workingEmployeeSplit;
        if(log.optionalserviceused()){
            workingEmployeeSplit = 0.25F;
        }else{
            workingEmployeeSplit = 0.33F;
        }
        return workingEmployeeSplit;
    }


    //method to allocate the money based of the employee id.
    public void allocateMoney(int employeeID){
        double amount = 0;
       for(Cost_Plan cost_plan: costPlans) {
           amount = cost_plan.getEventID().getBooking().ServiceFee() * employeeDistribution();

       }
        super.setEmployeeBalance(employeeID, amount);
    }

    //method to pay salary, the money based of the employee id and from the profit of the event.
    public void paySalary(int employeeID){
        double amount = 0;
        for(Cost_Plan cost_plan: costPlans) {
            amount = cost_plan.getProfit() * employeeDistribution();

        }
        super.setSalary(employeeID,amount);
    }





}

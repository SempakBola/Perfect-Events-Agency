import java.util.ArrayList;

public class Finance_Manager extends Employee { //finance manager class based of employee class

   private ArrayList<Cost_Plan> costPlans = new ArrayList<>();


   //constructor method
    public Finance_Manager(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Finance_Manager"); //position is always set to the employee subclass.
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
            workingEmployeeSplit = 0.25F; //100/4. As 4 working employee including logistic manager
        }else{
            workingEmployeeSplit = 0.33F; //100/3 without logistic manager
        }
        return workingEmployeeSplit;
    }


    //method to allocate the money based of the employee id.
    public void allocateMoney(int employeeID,int EventID){
        double amount = 0;
       for(Cost_Plan cost_plan: costPlans) {
           if(EventID == cost_plan.getEventID().getEventID()) { //matches the eventid
               amount = cost_plan.getEventID().getBooking().ServiceFee() * employeeDistribution();
           }else{
               System.out.println("wrong eventID");
           }
           //amount is uses the service fee

       }
        super.setEmployeeBalance(employeeID, amount);
    }

    //method to pay salary, the money based of the employee id and from the profit of the event.
    public void paySalary(int employeeID,EventID eventID){
        double amount = 0;
        for(Cost_Plan cost_plan: costPlans) {
            amount = cost_plan.getProfit(eventID) * employeeDistribution();

        }
        super.setSalary(employeeID,amount);
    }





}

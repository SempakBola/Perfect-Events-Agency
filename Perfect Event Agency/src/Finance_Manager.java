import java.util.ArrayList;

public class Finance_Manager extends Employee {

   private ArrayList<Cost_Plan> costPlans = new ArrayList<>();
    private  double company_balance = 100000;

    private float workingEmployeeSplit;

    public Finance_Manager(int employeeID, String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(employeeID, firstName, lastName, bill, salary, managedEvent, employeeBalance);
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


    public void checkForWorkingEmployees(){
        Logistics_Manager log = new Logistics_Manager();
        if(log.optionalserviceused()){
            workingEmployeeSplit = 0.25F;
        }else{
            workingEmployeeSplit = 0.33F;
        }

    }

    public void allocateMoney(int employeeID, double amount){
        EventID eventID = new EventID();
        double cost = eventID.getBooking().getTotalCost();
        amount = (company_balance - cost) * workingEmployeeSplit ;
        if(amount<0){
            amount = 0;
        }
        super.setEmployeeBalance(employeeID, amount);

    }

    public void paySalary(int employeeID, double amount){
        super.setSalary(employeeID,amount);
    }



}

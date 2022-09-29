import java.util.ArrayList;

public class Finance_Manager extends Employee {

    ArrayList<Cost_Plan> costPlans = new ArrayList<>();

    public Finance_Manager(int employeeID, String firstName, String lastName, String position, Double bill, Double salary) {
        super(employeeID, firstName, lastName, position, bill, salary);
    }

    public Finance_Manager() {

    }

    public ArrayList<Cost_Plan> getCostPlans() {
        return costPlans;
    }

    public void changeCostPlan(ArrayList<Cost_Plan> costPlans) {
        this.costPlans = costPlans;
    }

    public void allocateMoney(){

    }

    public void paySalary(){

    }

    public void updatePacakages(){

    }

}

import java.util.ArrayList;
import java.util.Random;

public class Employee { //employee constructor class
    private int employeeID;
    private String firstName;
    private String lastName;
    private String position;
    private double bill;
    private double Salary;

    private ArrayList<EventID> managedEvent = new ArrayList<>();

    private double employeeBalance;

    Random random = new Random();

    //constructor method for employee class


    public Employee(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        this.employeeID = random.nextInt(100000);
        this.firstName = firstName;
        this.lastName = lastName;
        this.bill = bill;
        Salary = salary;
        this.managedEvent = managedEvent;
        this.employeeBalance = employeeBalance;
    }

    public Employee() {
    }
    //getters and setters for the employee class
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(int employeeID, double salary) {
        if (this.employeeID == employeeID){
            Salary = salary;
        }
    }

    public void generateBill(){

    }

    public void updateProgress(){

    }

    public ArrayList<EventID> getManagedEvent() {
        return managedEvent;
    }

    public void setManagedEvent(ArrayList<EventID> managedEvent) {
        this.managedEvent = managedEvent;
    }

    public double getEmployeeBalance() {
        return employeeBalance;
    }

    public void setEmployeeBalance(int employeeID, double employeeBalance) {
        if (this.employeeID == employeeID){
            this.employeeBalance = employeeBalance;
        }

    }
}

public class Employee { //employee constructor class
    private int employeeID;
    private String firstName;
    private String lastName;
    private String position;
    private Double bill;
    private Double Salary;


    //constructor method for employee class
    public Employee(int employeeID, String firstName, String lastName, String position, Double bill, Double salary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bill = bill;
        this.Salary = salary;
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

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public void generateBill(){

    }

    public void updateProgress(){

    }
}

import java.util.ArrayList;

public class Logistics_Manager extends Employee{

    private  boolean optionalServiceRequested;
    //constructor method

    public Logistics_Manager(int employeeID, String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(employeeID, firstName, lastName, bill, salary, managedEvent, employeeBalance);
    }

    public Logistics_Manager() {

    }

    public void hireMusicBand(){


        optionalserviceused();
    }

    public void hireSoundSystem(){

        optionalserviceused();

    }
    public void orderFlowers(){
    optionalserviceused();
    }

    public boolean optionalserviceused(){
        return optionalServiceRequested;
    }



}

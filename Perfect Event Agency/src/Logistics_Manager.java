import java.util.ArrayList;

public class Logistics_Manager extends Employee{

    private  boolean optionalServiceRequested;
    EventID eventID = new EventID();
    Options options = new Options();

    //constructor method


    public Logistics_Manager(int employeeID, String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(employeeID, firstName, lastName, bill, salary, managedEvent, employeeBalance);
    }

    public Logistics_Manager() {

    }
    public void hireMusicBand(){
    options.isIsHireBand();
    optionalServiceRequested = true;
    }
    public void orderFlowers(){
    options.isIsFlowerDecoration();
   optionalServiceRequested = true;
    }
    public void hireSoundSystem(){
        options.isIsSoundSystem();
        optionalServiceRequested = true;
    }

    public boolean optionalserviceused(){
        return optionalServiceRequested;
    }

    public void getLogBill(){
        super.setBill(eventID.getBooking().getOptions().OptionCost());
    }


}

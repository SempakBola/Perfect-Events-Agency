import java.util.ArrayList;

public class Logistics_Manager extends Employee{

    private  boolean optionalServiceRequested;
    EventID eventID = new EventID();
    Options options = new Options();

    //constructor method


    public Logistics_Manager(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Logistic_Manager");
    }

    public Logistics_Manager() {
        super.setPosition("Logistic_Manager");
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

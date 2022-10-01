import java.util.ArrayList;

public class Logistics_Manager extends Employee{

    private  boolean optionalServiceRequested;
    private double costofBand = 1000.00;
    private double costofSoundSytem =  2000.00;
    private double costofFlowers = 500.00;
    Options options = new Options();
    Booking booking = new Booking();

    //constructor method


    public Logistics_Manager(int employeeID, String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(employeeID, firstName, lastName, bill, salary, managedEvent, employeeBalance);
    }

    public Logistics_Manager() {

    }

    public void hireMusicBand(){
        options.setIsHireBand(true);
        optionalserviceused();
    }

    public void hireSoundSystem(){
        options.setIsSoundSystem(true);
        optionalserviceused();

    }
    public void orderFlowers(){
    options.setIsFlowerDecoration(true);
    optionalserviceused();

    }

    public boolean optionalserviceused(){
        return optionalServiceRequested;
    }



}

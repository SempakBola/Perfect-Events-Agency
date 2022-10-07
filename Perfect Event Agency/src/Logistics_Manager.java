import org.w3c.dom.events.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Logistics_Manager extends Employee{

    private  boolean optionalServiceRequested;
    EventID eventID = new EventID();
    Options options = new Options();
   private static HashMap<Integer,String> LogisticManagerTasks = new HashMap<>();
   Customer customer = new Customer();


    //constructor method


    public Logistics_Manager(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Logistic_Manager");
    }

    public Logistics_Manager() {
        super.setPosition("Logistic_Manager");
    }
    public void hireMusicBand(EventID eventID){
        String[] tasks = { "talk to members of the band","Get the equipment for the band", "Check the mics and instruments", "rehearsal"};
        for(EventID eventID1: customer.getEvents()) {
            if (eventID ==eventID1) {
                LogisticManagerTasks.put(eventID1.getEventID(), Arrays.toString(tasks));
            }else {
                System.out.println("incorrect eventID");
            }
        }
        optionalServiceRequested = true;
    }
    public void orderFlowers(EventID eventID){
        String[] tasks = {"Choose flowers", "buy flower vase", "Place flowers around the venue"};
        for(EventID eventID1: customer.getEvents()) {
            if (eventID ==eventID1) {
                LogisticManagerTasks.put(eventID1.getEventID(), Arrays.toString(tasks));
            }else {
                System.out.println("incorrect eventID");
            }
        }
        optionalServiceRequested = true;
    }
    public void hireSoundSystem(EventID eventID){
        String[] tasks = {"Buy sound system", "Check sound", "Arrange speakers", "Arrange music"};
        for(EventID eventID1: customer.getEvents()) {
            if (eventID ==eventID1) {
                LogisticManagerTasks.put(eventID1.getEventID(), Arrays.toString(tasks));
            }else {
                System.out.println("incorrect eventID");
            }
        };
        optionalServiceRequested = true;
    }

    public boolean optionalserviceused(){
        return optionalServiceRequested;
    }

    public void getLogBill(){
        super.setBill(eventID.getBooking().getOptions().OptionCost());
    }

    public HashMap<Integer, String> getLogisticManagerTasks() {
        return LogisticManagerTasks;
    }

    public void setLogisticManagerTasks(HashMap<Integer, String> logisticManagerTasks) {
        LogisticManagerTasks = logisticManagerTasks;
    }
}

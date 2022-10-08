import org.w3c.dom.events.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Logistics_Manager extends Employee{

    private  boolean optionalServiceRequested;
    private ArrayList<EventID> eventIDArrayList = new ArrayList<>();
    Options options = new Options();
   private static HashMap<Integer,ArrayList<String>> LogisticManagerTasks = new HashMap<>();
   Customer customer = new Customer();


    //constructor method


    public Logistics_Manager(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Logistic_Manager");
    }

    public Logistics_Manager() {
        super.setPosition("Logistic_Manager");
    }
    public void hireMusicBand(int eventID){
        String[] tasks = { "talk to members of the band","Get the equipment for the band", "Check the mics and instruments", "rehearsal"};
        taskSetter(eventID, tasks);
        optionalServiceRequested = true;
    }
    public void orderFlowers(int eventID){
        String[] tasks = {"Choose flowers", "buy flower vase", "Place flowers around the venue"};
        taskSetter(eventID, tasks);
        optionalServiceRequested = true;
    }
    public void hireSoundSystem(int eventID){
        String[] tasks = {"Buy sound system", "Check sound", "Arrange speakers", "Arrange music"};
        taskSetter(eventID, tasks);
        optionalServiceRequested = true;
    }

    private void taskSetter(int eventID, String[] tasks) {
        ArrayList<String> allTasks = new ArrayList<>(Arrays.asList(tasks));
        for(EventID eventID1: customer.getEvents()) {
            if (eventID ==eventID1.getEventID()) {
                LogisticManagerTasks.put(eventID, allTasks);
            }else {
                System.out.println("incorrect eventID");
            }
        }
    }

    public boolean optionalserviceused(){
        return optionalServiceRequested;
    }

    public void getLogBill(int EventID){
        List<EventID> billLog = eventIDArrayList.stream().filter(f->f.getEventID() == EventID).collect(Collectors.toList());
        for(EventID event: billLog) {
            if(!billLog.equals("")){
                super.setBill(event.getBooking().getOptions().OptionCost());
                System.out.println(getBill());
                System.out.println("Bill generated");
            }else {
                System.out.println("Incorrect ID");
            }
        }
    }

    public  HashMap<Integer, ArrayList<String>> getLogisticManagerTasks() {
        return LogisticManagerTasks;
    }

    public static void setLogisticManagerTasks(HashMap<Integer, ArrayList<String>> logisticManagerTasks) {
        LogisticManagerTasks = logisticManagerTasks;
    }
}

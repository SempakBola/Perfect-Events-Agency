import org.w3c.dom.events.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Logistics_Manager extends Employee{ //logistic manager class that contains code for logistic manager functionality

    private  boolean optionalServiceRequested;
    private ArrayList<EventID> eventIDArrayList = new ArrayList<>();

    taskSetter taskSetter = new taskSetter();
    Options options = new Options();
   private static HashMap<Integer,ArrayList<String>> LogisticManagerTasks = new HashMap<>();
   Customer customer = new Customer();



    //constructor method
    public Logistics_Manager(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Logistic_Manager");
    }


    //empty constructor
    public Logistics_Manager() {
        super.setPosition("Logistic_Manager");
    }



    //Add tasks on hiring band to the logistic manager tasks.
    public void hireMusicBand(int eventID){
        options.setIsHireBand(true); //safety measurement to enforce that the band is hired
        String[] tasks = { "talk to members of the band","Get the equipment for the band", "Check the mics and instruments", "rehearsal"};
        taskSetter.setter(eventID, tasks,getLogisticManagerTasks()); //tasksetter class adds the task to the hashmap
        optionalServiceRequested = true;
    }

    //Adds tasks on ordering flowers to the logistic manager tasks
    public void orderFlowers(int eventID){
        options.setIsFlowerDecoration(true);
        String[] tasks = {"Choose flowers", "buy flower vase", "Place flowers around the venue"};
        taskSetter.setter(eventID, tasks,getLogisticManagerTasks());
        optionalServiceRequested = true;
    }

    //Adds tasks on hiring a sound system to the logistic manager task
    public void hireSoundSystem(int eventID){
        options.setIsSoundSystem(true);
        String[] tasks = {"Buy sound system", "Check sound", "Arrange speakers", "Arrange music"};
        taskSetter.setter(eventID, tasks,getLogisticManagerTasks());
        optionalServiceRequested = true;
    }



    public boolean optionalserviceused(){ //boolean method that checks if the optional service is used
        return optionalServiceRequested;
    }

    public void getLogBill(int EventID){ //method that gets the bill for the logistic manager
        List<EventID> billLog = eventIDArrayList.stream().filter(f -> f.getEventID() == EventID).collect(Collectors.toList());
        //filters the list to match the event ids
            if(!billLog.equals("")){ // checks if the list is not empty ie the event id exist
                billLog.forEach(f->setBill(f.getBooking().getOptions().OptionCost()));
                //sets the bill to the cost of the options used
                System.out.println(getBill());
                System.out.println("Bill generated");
            }else {
                System.out.println("Incorrect ID");
            }

    }

    //getter and setters for the arraylist

    public static HashMap<Integer, ArrayList<String>> getLogisticManagerTasks() {
        return LogisticManagerTasks;
    }

    public static void setLogisticManagerTasks(HashMap<Integer, ArrayList<String>> logisticManagerTasks) {
        LogisticManagerTasks = logisticManagerTasks;
    }
}

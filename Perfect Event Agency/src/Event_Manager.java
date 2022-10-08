import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Event_Manager extends Employee{ //event manager class

    private ArrayList<EventID> eventID = new ArrayList<>();
    ArrayList<Venue> venues = new ArrayList<>();
    Complaint complaint = new Complaint();

    Queries queries = new Queries();
    Customer customer = new Customer();
    private static HashMap<Integer, ArrayList<String>> eventManagerTasks = new HashMap<Integer, ArrayList<String>>();

    taskSetter taskSetter = new taskSetter();

    //constructor method
    public Event_Manager(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Event_Manager");
    }

    public Event_Manager() { //empty constructor method
        super.setPosition("Event_Manager");
    } //empty constructor




    //method to reply to queries
    public void handleQuery(int selectedEvent, String replyQueries){
        for(EventID event: eventID){
            if(selectedEvent == event.getEventID()){ //checks event id and if it matches then sends reply. reply is stored in  the customer class
                queries.setReply(replyQueries);
            }
        }

    }

    //method to reply to complaints
    public void handleComplaints(int selectedEvent, String replyComplaints){
        for(EventID event: eventID){
            if(selectedEvent == event.getEventID()){
                complaint.setReply(replyComplaints);
            }
        }
    }


    //method to book venue and add task to total tasks
    public void bookVenue(int eventID){
        String[] tasks = {"Book venue", "Clean place", " Set up seating arrangement", "place tables and chairs"};
        taskSetter.setter(eventID,tasks,getEventManagerTasks()); //use tasksetter utility to add task to the hashmap
    }

    public void makeChanges(int eventID){ //if changes occur adds changed method to tasks
        String[] tasks = {"Booking has been changed"};
        taskSetter.setter(eventID,tasks,getEventManagerTasks());
    }
    public void getVenueBill(int EventID) { //venue bill method
        List<EventID> billEvent = eventID.stream().filter(f -> f.getEventID() == EventID).collect(Collectors.toList());
        //matches the event id
        if (!billEvent.equals("")) {
            billEvent.forEach(f->setBill(f.getBooking().getVenue().getPrice())); //uses a for each loop to add the price to the bill
            System.out.println(getBill());
            System.out.println("Bill generated");
        } else {
            System.out.println("Incorrect ID");
        }
    }


    //getters and setters
    public static HashMap<Integer, ArrayList<String>> getEventManagerTasks() {
        return eventManagerTasks;
    }

    public static void setEventManagerTasks(HashMap<Integer, ArrayList<String>> eventManagerTasks) {
        Event_Manager.eventManagerTasks = eventManagerTasks;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Event_Manager extends Employee{ //event manager class

    ArrayList<EventID> eventID = new ArrayList<>();
    ArrayList<Venue> venues = new ArrayList<>();
    Complaint complaint = new Complaint();

    Queries queries = new Queries();
    Customer customer = new Customer();
    private static HashMap<Integer, ArrayList<String>> eventManagerTasks = new HashMap<Integer, ArrayList<String>>();

    //constructor method


    public Event_Manager(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Event_Manager");
    }

    public Event_Manager() { //empty constructor method
        super.setPosition("Event_Manager");
    }



    public void handleQuery(int selectedEvent, String replyQueries){
        for(EventID event: eventID){
            if(selectedEvent == event.getEventID()){
                queries.setReply(replyQueries);
            }
        }

    }
    public void handleComplaints(int selectedEvent, String replyComplaints){
        for(EventID event: eventID){
            if(selectedEvent == event.getEventID()){
                complaint.setReply(replyComplaints);
            }
        }
    }

    public void bookVenue(EventID eventID){
        String[] tasks = {"Book venue", "Clean place", " Set up seating arrangement", "place tables and chairs"};
        ArrayList<String> allTasks = new ArrayList<>(Arrays.asList(tasks));
        for(EventID eventID1: customer.getEvents()) {
            if(eventID == eventID1) {
                eventManagerTasks.put(eventID.getEventID(),allTasks);
            }else {
                System.out.println("incorrect Event ID");
            }
        }
    }


    public void getVenueBill(){
        for(EventID event: eventID) {
            super.setBill(event.getBooking().getVenue().getPrice());
            System.out.println(getBill());
        }
    }

    public HashMap<Integer, ArrayList<String>> getEventManagerTasks() {
        return eventManagerTasks;
    }

    public static void setEventManagerTasks(HashMap<Integer, ArrayList<String>> eventManagerTasks) {
        Event_Manager.eventManagerTasks = eventManagerTasks;
    }
}

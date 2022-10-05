import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Event_Manager extends Employee{ //event manager class

    ArrayList<EventID> eventID = new ArrayList<>();
    ArrayList<Venue> venues = new ArrayList<>();
    Complaint complaint = new Complaint();

    Queries queries = new Queries();


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

    public void bookVenue(String venue){
        List<Venue> selectedVenue = venues.stream().filter(f->f.getName().equalsIgnoreCase(venue)).collect(Collectors.toList());
        for (EventID eventID1: eventID){
            eventID1.getBooking().selectVenue((Venue) selectedVenue);
        }
    }


    public void getVenueBill(){
        for(EventID event: eventID) {
            super.setBill(event.getBooking().getVenue().getPrice());
            System.out.println(getBill());
        }
    }



}

import java.util.ArrayList;

public class Event_Manager extends Employee{ //event manager class

    ArrayList<EventID> eventID = new ArrayList<>();

    //constructor method


    public Event_Manager(int employeeID, String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(employeeID, firstName, lastName, bill, salary, managedEvent, employeeBalance);
    }

    public Event_Manager() { //empty constructor method
    }



    public void handleQuery(int selectedEvent, String replyQueries){
        Queries queries = new Queries();
        for(EventID event: eventID){
            if(selectedEvent == event.getEventID()){
                queries.setReply(replyQueries);
            }
        }


    }
    public void handleComplaints(int selectedEvent, String replyComplaints){

        Complaint complaint = new Complaint();
        for(EventID event: eventID){
            if(selectedEvent == event.getEventID()){
                complaint.setReply(replyComplaints);
            }
        }

    }

    public void bookVenue(){


    }


    public void getVenueBill(){
        for(EventID event: eventID) {
            super.setBill(event.getBooking().getVenue().getPrice());
            System.out.println(getBill());
        }
    }



}

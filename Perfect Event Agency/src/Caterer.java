import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Caterer extends Employee { //Caterer class that is responsible for the arrangement of food and beverages
    EventID eventID = new EventID();
    FoodSelection foodSelection = new FoodSelection();
    private static HashMap<Integer,String>  catererTask = new HashMap<>();
    Customer customer = new Customer();

    //constructor class for the caterer


    public Caterer(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Caterer");
    }

    public Caterer() { //empty constructor for flexiblilty.
        super.setPosition("Caterer");

    }

    public void arrangeFoodandBeverages(EventID eventID){ //method that operates the caterer operation
        String[] tasks = {"Buy Food", "Buy Drinks","Arrange Food and Drinks on table"};
        for(EventID eventID1: customer.getEvents()) {
            if(eventID == eventID1) {
                catererTask.put(eventID.getEventID(), Arrays.toString(tasks));
            }else {
                System.out.println("incorrect eventID");
            }
        }
    }

    public void arrangeCutlery(EventID eventID){
        String[] tasks = {"Buy utensils", "Buy plates", "Arrange Plates"};
        for(EventID eventID1: customer.getEvents()) {
            if (eventID == eventID1) {
                catererTask.put(eventID1.getEventID(), Arrays.toString(tasks));
            }else{
                System.out.println("Incorrect eventID");
            }
        }

    }

    public void pickupFood(EventID eventID){
        String[] tasks = {"Order Food", "Pickup food", "Deliver Food"};
        for(EventID eventID1: customer.getEvents()) {
            if(eventID == eventID1) {
                catererTask.put(eventID1.getEventID(), Arrays.toString(tasks));
            }else {
                System.out.println("incorrect EventID");
            }
        }

    }

    public HashMap<Integer, String> getCatererTask() {
        return catererTask;
    }

    public void setCatererTask(HashMap<Integer, String> catererTask) {
        Caterer.catererTask = catererTask;
    }

    public void getMenuBill(){
        super.setBill(eventID.getBooking().getFoodSelection().getPrice());
        System.out.println(getBill());
    }
}

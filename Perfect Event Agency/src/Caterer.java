import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Caterer extends Employee { //Caterer class that is responsible for the arrangement of food and beverages
    private ArrayList<EventID> eventIDArrayList = new ArrayList<>();
    FoodSelection foodSelection = new FoodSelection();
    private HashMap<Integer,ArrayList<String>>  catererTask = new HashMap<>();
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
        taskSetter(eventID,tasks);
    }

    public void arrangeCutlery(EventID eventID){
        String[] tasks = {"Buy utensils", "Buy plates", "Arrange Plates"};
        taskSetter(eventID,tasks);

    }

    public void pickupFood(EventID eventID){
        String[] tasks = {"Order Food", "Pickup food", "Deliver Food"};
       taskSetter(eventID,tasks);

    }

    private void taskSetter(EventID eventID, String[] tasks) {
        ArrayList<String> allTasks = new ArrayList<>(Arrays.asList(tasks));
        for(EventID eventID1: customer.getEvents()) {
            if (eventID ==eventID1) {
                catererTask.put(eventID1.getEventID(), allTasks);
            }else {
                System.out.println("incorrect eventID");
            }
        }
    }

    public  HashMap<Integer, ArrayList<String>> getCatererTask() {
        return catererTask;
    }

    public  void setCatererTask(HashMap<Integer, ArrayList<String>> catererTask) {
        this.catererTask = catererTask;
    }

    public void getMenuBill(int EventID){
        List<EventID> billMenue = eventIDArrayList.stream().filter(f->f.getEventID() == EventID).collect(Collectors.toList());
        for(EventID event: billMenue) {
            if(!billMenue.equals("")){
                super.setBill(event.getBooking().getFoodSelection().getPrice());
                System.out.println(getBill());
            }else {
                System.out.println("Incorrect ID");
            }
        }
    }
}

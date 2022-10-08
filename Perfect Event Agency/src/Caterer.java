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

    public void arrangeFoodandBeverages(int eventID){ //method that operates the caterer operation
        String[] tasks = {"Buy Food", "Buy Drinks","Arrange Food and Drinks on table"};
        taskSetter(eventID,tasks);
    }

    public void arrangeCutlery(int eventID){
        String[] tasks = {"Buy utensils", "Buy plates", "Arrange Plates"};
        taskSetter(eventID,tasks);

    }

    public void pickupFood(int eventID){
        String[] tasks = {"Order Food", "Pickup food", "Deliver Food"};
       taskSetter(eventID,tasks);

    }

    private void taskSetter(int eventID, String[] tasks) {
        ArrayList<String> allTasks = new ArrayList<>(Arrays.asList(tasks));
        for(EventID eventID1: customer.getEvents()) {
            if (eventID ==eventID1.getEventID()) {
                catererTask.put(eventID, allTasks);
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
            if(!billMenue.equals("")){
                billMenue.forEach(f->setBill(f.getBooking().getFoodSelection().getPrice()));
                System.out.println(getBill());
                System.out.println("Bill generated");
            }else {
                System.out.println("Incorrect ID");
            }

    }
}

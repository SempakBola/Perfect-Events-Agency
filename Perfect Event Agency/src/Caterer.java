import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Caterer extends Employee { //Caterer class that is responsible for the arrangement of food and beverages

    private static HashMap<Integer,ArrayList<String>>  catererTask = new HashMap<>();
    Customer customer = new Customer();
    taskSetter taskSetter = new taskSetter();

    //constructor class for the caterer


    public Caterer(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Caterer");
    }

    public Caterer() { //empty constructor.
        super.setPosition("Caterer");

    }

    public void arrangeFoodandBeverages(int eventID){ //method that adds the food and beverages to caterer tasks
        String[] tasks = {"Buy Food", "Buy Drinks","Arrange Food and Drinks on table"};
        taskSetter.setter(eventID,tasks,getCatererTask()); //uses task setter to add to the caterer hashmap
    }

    public void arrangeCutlery(int eventID){ //method that adds the arrange cutlery to caterer tasks
        String[] tasks = {"Buy utensils", "Buy plates", "Arrange Plates"};
        taskSetter.setter(eventID,tasks,getCatererTask());

    }

    public void pickupFood(int eventID){ //method that adds the pickup food to caterer tasks
        String[] tasks = {"Order Food", "Pickup food", "Deliver Food"};
        taskSetter.setter(eventID,tasks,getCatererTask());

    }

    //setter and getter
    public  static HashMap<Integer, ArrayList<String>> getCatererTask() {
        return catererTask;
    }

    public  void setCatererTask(HashMap<Integer, ArrayList<String>> catererTask) {
        Caterer.catererTask = catererTask;
    }


    //bill to get the menu cost from the customer class
    public void getMenuBill(int EventID){
        List<EventID> billMenue = customer.getEvents().stream().filter(f->f.getEventID() == EventID).collect(Collectors.toList());
        //matches the given event id with the existing event id
            if(!billMenue.equals("")){
                billMenue.forEach(f->setBill(f.getBooking().getFoodSelection().getPrice()));
                System.out.println(getBill());
                System.out.println("Bill generated");
            }else {
                System.out.println("Incorrect ID");
            }

    }
}

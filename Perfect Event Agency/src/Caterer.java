import java.util.ArrayList;

public class Caterer extends Employee { //Caterer class that is responsible for the arrangement of food and beverages
    EventID eventID = new EventID();
    FoodSelection foodSelection = new FoodSelection();

    //constructor class for the caterer


    public Caterer(String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Caterer");
    }

    public Caterer() { //empty constructor for flexiblilty.
        super.setPosition("Caterer");

    }

    public void arrangeFoodandBeverages(){ //method that operates the caterer operation

    }

    public void arrangeCutlery(){

    }

    public void pickupFood(){

    }

    public void getMenuBill(){
        super.setBill(eventID.getBooking().getFoodSelection().getPrice());
        System.out.println(getBill());
    }
}

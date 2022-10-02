import java.util.ArrayList;

public class Caterer extends Employee { //Caterer class that is responsible for the arrangement of food and beverages
    EventID eventID = new EventID();

    //constructor class for the caterer


    public Caterer(int employeeID, String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(employeeID, firstName, lastName, bill, salary, managedEvent, employeeBalance);
        super.setPosition("Caterer");
    }

    public Caterer() { //empty constructor for flexiblilty.
    }

    public void arrangeFoodandBeverages(){ //method that operates the caterer operation
        FoodSelection foodSelection = new FoodSelection();
        foodSelection.getFoodandBeveragePackage();
    }

    public void getMenuBill(){
        super.setBill(eventID.getBooking().getFoodSelection().getPrice());
        System.out.println(getBill());
    }
}

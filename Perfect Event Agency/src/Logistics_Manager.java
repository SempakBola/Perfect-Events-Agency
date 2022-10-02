import java.util.ArrayList;

public class Logistics_Manager extends Employee{

    private  boolean optionalServiceRequested;

    Options options = new Options();
    Booking booking = new Booking();

    //constructor method


    public Logistics_Manager(int employeeID, String firstName, String lastName, double bill, double salary, ArrayList<EventID> managedEvent, double employeeBalance) {
        super(employeeID, firstName, lastName, bill, salary, managedEvent, employeeBalance);
    }

    public Logistics_Manager() {

    }

    public void selectedOption(Options option, Double amount){

      /*  if(options.isIsHireBand()){
           options.setIsHireBand(true);
           amount = options.getCostofBand();

        }
        if(option == "Flower Decoration"){
            options.isIsFlowerDecoration();
            amount = options.getCostofFlowers();

        }
        if(option == "Sound System"){
            options.isIsSoundSystem();
            amount = options.getCostofSoundSytem();
        }
         */
        optionalServiceRequested = true;
    }

    public boolean optionalserviceused(){
        return optionalServiceRequested;
    }


}

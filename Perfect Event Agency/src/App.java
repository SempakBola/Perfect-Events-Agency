import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    private static final ArrayList<EventID> eventID = new ArrayList<>();

    public void printSeperator() {
        System.out.println("------------------------------------------------------------");
    }

    public static void main(String[] args) { //contains the code for the UI;
        int choice = 0;
        //test data
        ArrayList<Venue> venues = new ArrayList<Venue>();
        venues.add(new Venue("The Ballroom", 100, 15000, true,1));
        venues.add(new Venue("The Grand Hall", 50, 5000, true,2));
        venues.add(new Venue("The Grand Ballroom", 120, 8000, true,3));
        venues.add(new Venue("The Westin", 200, 20000, true,4));
        venues.add(new Venue("The Hilton", 30, 2000, true,5));
        venues.add(new Venue("The Marriott", 150, 10000, true,6));
        venues.add(new Venue("The Sheraton", 15, 1000, true,7));

        ArrayList<FoodSelection> foodSelections = new ArrayList<FoodSelection>();
        foodSelections.add(new FoodSelection("Food Plan A", 1000,1));
        foodSelections.add(new FoodSelection("Food Plan B", 2000, 2));
        foodSelections.add(new FoodSelection("Food Plan C", 3000, 3));
        foodSelections.add(new FoodSelection("Food Plan D", 4000, 4));

        ArrayList<Packages> packages = new ArrayList<Packages>();
        packages.add(new Packages(1, "Package A FROM $1100", 15));
        packages.add(new Packages(2, "Package B FROM $6000 ", 50));
        packages.add(new Packages(3, "Package C FROM $11000", 150));

        App app = new App();
        Customer customer = new Customer();
        Finance_Manager finance_manager = new Finance_Manager();
        Logistics_Manager logistics_manager = new Logistics_Manager();
        Event_Manager event_manager = new Event_Manager();
        Caterer caterer = new Caterer();
        Tracker tracker = new Tracker();
        Employee employee = new Employee();

        

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to the Perfect Events Agency\n");
            System.out.println("Choose your role:" + "\n" + "1. Employee" + "\n" + "2. Customer" + "\n3. Exit");
            choice = sc.nextInt();
            app.printSeperator();
            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice");
            }
            //Employee View
            if (choice == 1) {

                app.printSeperator();
                System.out.println("Welcome to Employee Portal");
                int sub_choice1 = 0;

                //Choose role
                do {
                    System.out.println("Pick your role:" + "\n" + "1. Event Manager" + "\n" + "2. Finance Manager" + "\n" + "3. Logistics Manager" + "\n4. Caterer");
                    sub_choice1 = sc.nextInt();
                    if (sub_choice1 < 1 || sub_choice1 > 4) {
                        System.out.println("Invalid choice");
                    }
                    switch (sub_choice1) {
                        case 1:
                            boolean correctEventID = false;
                            //EventManager
                            System.out.println("Welcome to Event Manager Portal");
                            int sub_choice2 = 0;
                            do {
                                //input event manager functions
                                //ENTER CODE HERE. Make changes to the options below if needed
                                System.out.println("1. Handle Query" + "\n" + "2. Handle Complaints" + "\n" + "3. Book Venue" + "\n" +
                                        "4. Handle Changes" + "\n" + "5. Track Progress" + "\n" + "6. Update Progress" + "\n7. Generate Bill" + "\n8.Back");
                                sub_choice2 = sc.nextInt();
                                switch (sub_choice2) {
                                    case 1:
                                                   customer.getComplaints().forEach(System.out::println);
                                                    System.out.println("Would you like to reply? Answer YES or NO");
                                                    String confrimReplyComplaint = sc.nextLine();
                                                   switch (confrimReplyComplaint.toLowerCase()){
                                                       case "yes":
                                                           System.out.println("Enter event id");
                                                           int complaintEventID = sc.nextInt();
                                                           List<Complaint> chosenEvent =
                                                                   customer.getComplaints().stream().filter(f->f.getEventID().getEventID() == complaintEventID).collect(Collectors.toList());
                                                            if(!chosenEvent.equals("")){
                                                                System.out.println("Enter reply");
                                                                String reply = sc.nextLine();
                                                                event_manager.handleComplaints(complaintEventID,reply);
                                                            }
                                                           break;
                                                       case "no":
                                                           break;
                                                       default:
                                                           System.out.println("Incorrect");
                                                           break;
                                                   }

                                    case 2:
                                        customer.getQueries().forEach(System.out::println);
                                        System.out.println("Would you like to reply? Answer YES or NO");
                                        String confrimReplyQuery = sc.nextLine();
                                        switch (confrimReplyQuery.toLowerCase()){
                                            case "yes":
                                                System.out.println("Enter event id");
                                                int queriesEventID = sc.nextInt();
                                                List<Queries> chosenEvent =
                                                        customer.getQueries().stream().filter(f-> f.getQueryID() == queriesEventID).collect(Collectors.toList());
                                                if(!chosenEvent.equals("")){
                                                    System.out.println("Enter reply");
                                                    String reply = sc.nextLine();
                                                    event_manager.handleQuery(queriesEventID,reply);
                                                }while(chosenEvent.equals("")){
                                                System.out.println("Incorrect eventID");
                                                 sc.nextInt();
                                            }
                                                break;
                                            case "no":
                                                break;
                                            default:
                                                System.out.println("Incorrect");
                                                break;
                                        }

                                    case 3:
                                        //Book Venue
                                        System.out.println("Enter the event ID to book venue");
                                        int bookVenueEventID = sc.nextInt();
                                        for(EventID eventID1: customer.getEvents()){
                                            if(bookVenueEventID == eventID1.getEventID()){
                                                event_manager.bookVenue(eventID1);
                                            }
                                        }
                                        break;
                                    case 4:
                                        //Handle Changes
                                        //ENTER CODE HERE
                                        break;
                                    case 5:
                                        //Track Progress
                                        System.out.println("Enter eventID for the event you want to track");
                                        int trackingEventID = sc.nextInt();
                                        tracker.checkProgress(trackingEventID);
                                        break;
                                    case 6:
                                        //Update Progress
                                        System.out.println("Enter eventID for the event you want to track");
                                        int updatingEventID = sc.nextInt();
                                        tracker.UpdateProgress(updatingEventID,sc);
                                        break;
                                    case 7:
                                        //Generate Bill
                                        System.out.println("Enter event id for bill");
                                       int billEventID  = sc.nextInt();
                                       event_manager.getVenueBill(billEventID);

                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                }
                            } while (sub_choice2 != 8);
                            break;
                        case 2:
                            //FinanceManager
                            System.out.println("Welcome to Finance Manager Portal");
                            int sub_choice3 = 0;
                            do {
                                System.out.println("1. Create Cost Plan" + "\n" + "2. Change Cost Plan" + "\n" + "3. Allocate Money" + "\n" +
                                        "4. Pay Salary" + "\n" + "5. Track Progress" + "\n" + "6. Update Progress" + "\n7. Update Packages" + "\n8. Back");
                                sub_choice3 = sc.nextInt();
                                switch (sub_choice3) {
                                    case 1:
                                        //Create Cost Plan
                                            System.out.println("Enter the eventID for the costPlan");
                                            int selectedEventID = sc.nextInt();
                                            for (Cost_Plan newCostplan : finance_manager.getCostPlans()) {
                                                for (EventID eventID1 : eventID) {
                                                    if (selectedEventID != newCostplan.getEventID().getEventID() || eventID1.getEventID() == selectedEventID) {
                                                        System.out.println("Valid Event id.");
                                                        finance_manager.getCostPlans().add(new Cost_Plan(eventID.get(selectedEventID)));
                                                        break;
                                                    }
                                                    while (selectedEventID == newCostplan.getEventID().getEventID()) {
                                                        System.out.println("Event id already has a costplan");
                                                        sc.nextLine();
                                                    }while(selectedEventID != eventID1.getEventID()) {
                                                        System.out.println("Event id does not exist try again");
                                                        selectedEventID = sc.nextInt();
                                                    }
                                                }
                                            }
                                        System.out.println("Create Cost Plan");
                                        break;
                                    case 2:
                                        //Change Cost Plan
                                        System.out.println("Would you like to change an EventID from the costplan?" + "\n"+
                                                "Enter YES or NO");
                                        String changeCostPlan = sc.nextLine();
                                        switch (changeCostPlan.toLowerCase()){
                                            case "yes":
                                                System.out.println("Enter Costplan ID to change");
                                                boolean correctCostplanID = false;
                                                int costplanidChangning = sc.nextInt();
                                                while (!correctCostplanID){
                                                    for(Cost_Plan cost_plan: finance_manager.getCostPlans()){
                                                        if(costplanidChangning == cost_plan.getCostPlanID()){
                                                            System.out.println("Enter new event id for this costplan");
                                                            int newEventID = sc.nextInt();
                                                            cost_plan.getEventID().setEventID(newEventID);
                                                        }else{
                                                            System.out.println("Incorrect ID. Try again");
                                                            sc.nextLine();
                                                        }
                                                    }
                                                }

                                                break;
                                            case "no":
                                                break;
                                            default:
                                                System.out.println("Invalid answer");
                                                break;
                                        }
                                        break;
                                    case 3:
                                        //Allocate Money
                                        boolean allocateEmployeeID = false;
                                        while (!allocateEmployeeID) {
                                            System.out.println("Money is auto-calculated and distributed from the revenue generated. " +
                                                    "\n" + "Enter the employeeID: ");

                                            int enteredEmployeeID = sc.nextInt();
                                            if (enteredEmployeeID == employee.getEmployeeID()) {
                                                finance_manager.allocateMoney(enteredEmployeeID);
                                                break;
                                            } else {
                                                System.out.println("Enter valid EmployeeID:");
                                                sc.nextLine();
                                            }
                                        }

                                        break;
                                    case 4:
                                        //Pay Salary
                                        boolean salaryEmployeeID = false;
                                        while (!salaryEmployeeID) {
                                            System.out.println("Money is auto-calculated and distributed from the profit generated. " +
                                                    "\n" + "Enter the employeeID: ");
                                            int enteredEmployeeID = sc.nextInt();
                                            if (enteredEmployeeID == employee.getEmployeeID()) {
                                                salaryEmployeeID = true;
                                                finance_manager.paySalary(enteredEmployeeID);
                                                break;
                                            } else {
                                                System.out.println("Enter valid EmployeeID:");
                                                sc.nextLine();
                                            }
                                        }
                                        break;
                                    case 5:
                                        //Track Progress
                                        System.out.println("Enter eventID for the event you want to track");
                                        int trackingEventID = sc.nextInt();
                                        tracker.checkProgress(trackingEventID);
                                        break;
                                    case 6:
                                        //Update Progress
                                        System.out.println("Enter eventID for the event you want to update");
                                        int updatingEventID = sc.nextInt();
                                        tracker.UpdateProgress(updatingEventID,sc);
                                        break;
                                    case 7:
                                        //Update Packages
                                        boolean correctPackage = false;
                                        while (!correctPackage) {
                                            System.out.println("Enter package number to change");
                                            int chosenPackage = sc.nextInt();
                                            for (Packages updatePackages : packages) {
                                                if (chosenPackage == updatePackages.getPackage_num()) {
                                                    correctPackage = true;
                                                    System.out.println("Capacity: " + updatePackages.getCapacity()
                                                            + "Details: " + updatePackages.getDetails());
                                                    System.out.println("Choose 1 to change Capacity or choose 2 for Details");
                                                    int chosenUpdate = sc.nextInt();
                                                    switch (chosenUpdate) {
                                                        case 1 -> {
                                                            System.out.println("Enter new capacity");
                                                            int newCapacity = sc.nextInt();
                                                            updatePackages.setCapacity(newCapacity);
                                                        }
                                                        case 2 -> {
                                                            System.out.println("Enter new details");
                                                            String newDetails = sc.nextLine();
                                                            updatePackages.setDetails(newDetails);
                                                        }
                                                        default -> {
                                                            System.out.println("Invalid choice");

                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Invalid package number try again");
                                                    sc.nextLine();
                                                }

                                            }
                                            break;
                                        }
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                }
                            } while (sub_choice3 != 8);
                            break;
                        case 3:
                            //LogisticsManager
                            System.out.println("Welcome to Logistics Manager Portal");
                            int sub_choice4 = 0;
                            do {
                                System.out.println("1. Hire Musical Band" + "\n" + "2. Hire Sound System" + "\n" + "3. Order Flowers" + "\n" +
                                        "4. Track Progress" + "\n" + "5. Update Progress" + "\n" + "6. Generate Bill" + "\n7. Back");
                                sub_choice4 = sc.nextInt();
                                switch (sub_choice4) {
                                    case 1:
                                        //Hire Musical Band
                                        boolean validMusicBandEventID = false;
                                        System.out.println("Enter the eventid to hire music band");
                                        int musicEvemtID = sc.nextInt();
                                            for(EventID event: customer.getEvents()){
                                                if(musicEvemtID == event.getEventID()){
                                                    logistics_manager.hireMusicBand(event);
                                                    break;
                                                }
                                            }


                                    case 2:
                                        boolean validSoundSystemEventID = false;
                                        System.out.println("Enter the eventid to hire music band");
                                        int soundEventID = sc.nextInt();
                                            for(EventID event: customer.getEvents()){
                                                if(soundEventID == event.getEventID()){
                                                    validSoundSystemEventID = true;
                                                    logistics_manager.hireSoundSystem(event);
                                                    break;
                                                }
                                            }

                                    case 3:
                                        //Order Flowers
                                        boolean validorderFlowerEventID = false;
                                        System.out.println("Enter the eventid to hire music band");
                                        int flowerEventID = sc.nextInt();
                                            for(EventID event: customer.getEvents()){
                                                if(flowerEventID == event.getEventID()){
                                                    validorderFlowerEventID = true;
                                                    logistics_manager.orderFlowers(event);
                                                    break;
                                                }
                                            }

                                    case 4:
                                        //Track Progress
                                        System.out.println("Enter eventID for the event you want to track");
                                        int trackingEventID = sc.nextInt();
                                        tracker.checkProgress(trackingEventID);
                                        break;
                                    case 5:
                                        //Update Progress
                                        System.out.println("Enter eventID for the event you want to update");
                                        int updatingEventID = sc.nextInt();
                                        tracker.UpdateProgress(updatingEventID,sc);
                                        break;
                                    case 6:
                                        //Generate Bill
                                        System.out.println("Enter event id for bill");
                                        int billEventID  = sc.nextInt();
                                        logistics_manager.getLogBill(billEventID);
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                }
                            } while (sub_choice4 != 7);
                            break;
                        case 4:
                            //Caterer
                            System.out.println("Welcome to Caterer Portal");
                            int sub_choice5 = 0;
                            do {
                                System.out.println("1. Arrange Food and Beverage" + "\n" +
                                                "2. Arrange Cutlery" + "\n"  +
                                                "3. Pick up food" + "\n" +
                                        "4. Track Progress" + "\n" + "5. Update Progress" + "\n" + "6. Generate Bill" + "\n7. Back");
                                sub_choice5 = sc.nextInt();
                                switch (sub_choice5) {
                                    case 1:
                                        //Arrange Food and Beverage
                                        System.out.println("Enter the event ID for the food and beverages");
                                        int foodandbevEventID = sc.nextInt();
                                        for(EventID eventID1: customer.getEvents()){
                                         if(foodandbevEventID == eventID1.getEventID()){
                                             caterer.arrangeFoodandBeverages(eventID1);
                                         }
                                        }
                                        break;
                                    case 2:
                                        //Arrange cutlery
                                        System.out.println("Enter the event ID for the cutlery");
                                        int arrangeCutleryID = sc.nextInt();
                                        for(EventID eventID1: customer.getEvents()){
                                            if(arrangeCutleryID == eventID1.getEventID()){
                                                caterer.arrangeCutlery(eventID1);
                                            }
                                        }
                                        break;

                                    case 3:
                                        //pick up food
                                        System.out.println("Enter the event ID to pickup food");
                                        int foodpickupEventID = sc.nextInt();
                                        for(EventID eventID1: customer.getEvents()){
                                            if(foodpickupEventID == eventID1.getEventID()){
                                                caterer.pickupFood(eventID1);
                                            }
                                        }

                                    case 4:
                                        //Track Progress
                                        System.out.println("Enter eventID for the event you want to track");
                                        int trackingEventID = sc.nextInt();
                                        tracker.checkProgress(trackingEventID);
                                        break;
                                    case 5:
                                        //Update Progress
                                        System.out.println("Enter eventID for the event you want to update");
                                        int updatingEventID = sc.nextInt();
                                        tracker.UpdateProgress(updatingEventID,sc);
                                        break;
                                    case 6:
                                        //Generate Bill
                                        System.out.println("Enter event id for bill");
                                        int billEventID  = sc.nextInt();
                                        caterer.getMenuBill(billEventID);
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                }
                            } while (sub_choice5 != 7);
                            break;

                        default:
                            break;
                    }

                } while (sub_choice1 < 1 || sub_choice1 > 4);
            } else if (choice == 2) {
                System.out.println("Welcome to Customer Portal");
                int sub_choice6 = 0;
                Scanner sc1 = new Scanner(System.in);
                do {
                    System.out.println("\n1. View Packages" + "\n2. Book Event" + "\n3. Track Progress" + "\n4. Create Query" +
                            "\n5. Make Complaint" + "\n6. Request Refund and Cancel" + "\n7. Change Booking" +
                            "\n8. Check Balance" + "\n9. Deposit Money" + "\n10. View Profile" + "\n11. Inspect a Venue" +"\n12. Back");
                    sub_choice6 = sc1.nextInt();
                    switch (sub_choice6) {
                        case 1:
                            //View Packages
                            //ENTER CODE HERE
                            customer.viewPackages(packages);
                            break;
                        case 2:
                            //Create Booking
                            //ENTER CODE HERE

                            Booking booking =new Booking();

                            //selecting package
                            customer.viewPackages(packages);
                            System.out.println("Enter the package id number you want to book");
                            int packageId=sc1.nextInt();
                            booking.selectPackage(packages,packageId);

                            //entering the number of attendees
                            System.out.println("Enter the number of attendees: ");
                            booking.setAttendees(sc1.nextInt());

                            //selecting venue
                            customer.showAvailableVenues(venues, booking);
                            System.out.println("Enter the venue id number you want to book: ");
                            int venueId=sc1.nextInt();
                            booking.selectVenue(venues,venueId);

                            //selecting food and beverage
                            customer.viewFood(foodSelections);
                            System.out.println("Enter the food id number you want to book: ");
                            int foodId=sc1.nextInt();
                            booking.SelectFood(foodSelections, foodId);

                            //select options
                            Options option = new Options();
                            System.out.println("Do you want a soundsystem? (y/n)");
                            String soundSystem=sc1.next();
                            if(soundSystem.equals("y")){
                                option.setIsSoundSystem(true);
                            }
                            System.out.println("Do you want a musical band? (y/n)");
                            String musicalBand=sc1.next();
                            if(musicalBand.equals("y")){
                                option.setIsHireBand(true);
                            }
                            System.out.println("Do you want flower decorations? (y/n)");
                            String flowers=sc1.next();
                            if(flowers.equals("y")){
                                option.setIsFlowerDecoration(true);
                            }
                            booking.selectOptions(option);
                            
                            //create booking
                            System.out.println("Enter your first name: ");
                            String firstName=sc1.next();
                            System.out.println("Enter your last name: ");
                            String lastName=sc1.next();
                            System.out.println("Enter your date of birth: ");
                            String dob=sc1.next();
                            System.out.println("Enter your address: ");
                            String address=sc1.next();
                            System.out.println("Enter your phone number: ");
                            int phone=sc1.nextInt();
                            System.out.println("Select a payment method (enter number): \n1. Credit Card \n2. Debit Card \n3. Net Banking");
                            int paymentMethod=sc1.nextInt();
                            switch (paymentMethod) {
                                case 1:
                                    customer.createBooking(customer,booking, "Credit Card", 
                                    firstName, lastName, dob, address, phone);
                                    break;
                                case 2:
                                customer.createBooking(customer,booking, "Debit Card", 
                                    firstName, lastName, dob, address, phone);
                                    break;

                                case 3:
                                customer.createBooking(customer,booking, "Net Banking", 
                                    firstName, lastName, dob, address, phone);
                                    break;
                            }

                            break;
                        case 3:
                            //Track Progress
                            //ENTER CODE HERE
                            if(customer.viewEvents()==true){
                                System.out.println("Enter eventID for the event you want to track: ");
                                int trackingEventID = sc1.nextInt();
                                for (EventID eventID1 : customer.getEvents()) {
                                    if (trackingEventID == eventID1.getEventID()) {
                                        eventID1.getTracker().checkProgress(trackingEventID);
                                    }
                                }
                                break;
                            }
                            break;
                        case 4:
                            //Create Query
                            //ENTER CODE HERE
                            sc.nextLine();
                            System.out.println("Enter your query: ");
                            customer.createQuery(sc.nextLine());
                            break;
                        case 5:
                            //Make Complaint
                            //ENTER CODE HERE
                            app.printSeperator();
                            if (customer.viewEvents()==true){
                                System.out.println("Enter the event number you want to make a complaint for: ");
                                int eventNumber = sc1.nextInt();
                                System.out.println("Enter your complaint: ");
                                customer.makeComplaint(eventNumber, sc1.nextLine());
                            }
                            break;
                        case 6:
                            //Request Refund and Cancel
                            //ENTER CODE HERE
                            app.printSeperator();
                            if (customer.viewEvents()==true){
                                System.out.println("Enter the event number you want to cancel: ");
                                int eventNumber = sc1.nextInt();
                                System.out.println("Enter the details to your refund: ");
                                String details= sc.nextLine();
                                for (EventID event: customer.getEvents()){
                                    if (event.getEventID()==eventNumber){
                                        customer.requestRefund(customer, event,details);
                                    }

                                }
                                
                            }
                            
                            break;
                        case 7:
                            //Change Booking
                            //ENTER CODE HERE
                            app.printSeperator();
                            if(customer.viewEvents()==true){
                                System.out.println("Enter the event id you want to change");
                                int eventID=sc.nextInt();
                                customer.changeBooking(eventID, foodSelections);
                            break;
                            }else{
                                System.out.println("You have no events yet, please book one first.");
                                break;
                            }

                        case 8:
                            //check balance
                            //ENTER CODE HERE
                            app.printSeperator();
                            System.out.println("Your balance is: "+customer.getBalance());
                            break;
                        case 9:
                            //Deposit Money
                            //ENTER CODE HERE
                            app.printSeperator();
                            System.out.println("Enter the amount you want to deposit: ");
                            customer.setBalance(sc.nextFloat()+customer.getBalance());
                            System.out.println("Your new balance is: "+customer.getBalance());
                            break;
                        case 10:
                            //view customer details
                            //ENTER CODE HERE
                            app.printSeperator();
                            customer.customerDetails();
                            break;
                        case 11:
                            //Book Inspection
                            customer.viewAllVenues(venues);
                            System.out.println("Enter the venue id number you want to book an inspection for: ");
                            int venueId2=sc1.nextInt();
                            customer.bookInspection(venues, venueId2);
                            break;
                            
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                } while (sub_choice6 != 12);
            }
        } while (choice != 3);
        
    }



}

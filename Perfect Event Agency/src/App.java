import java.util.ArrayList;
import java.util.Scanner;

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
                            boolean validAnswer = false;
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
                                        while (!validAnswer) {
                                                    for(Complaint complaint: customer.getComplaints()){
                                                        System.out.println("EventID: "+ complaint.getEventID().getEventID() +
                                                                "Complaints: " + complaint.getDetails());
                                                    }
                                                    System.out.println("Would you like to reply? Answer YES or NO");
                                                    String confirmReplyQuery = sc.nextLine();
                                                    if (confirmReplyQuery.toLowerCase().equals("YES")) {
                                                        validAnswer = true;
                                                        System.out.println("Enter reply");
                                                        String replyQuery = sc.nextLine();

                                                        while (!correctEventID) {
                                                            System.out.println("Enter the event id for the reply");
                                                            int replyEventID = sc.nextInt();
                                                            for (Complaint complaint : customer.getComplaints()) {
                                                                if (replyEventID == complaint.getEventID().getEventID()){
                                                                    event_manager.handleQuery(replyEventID, replyQuery);
                                                                    correctEventID = true;
                                                                    break;
                                                                } else{
                                                                    System.out.println("Incorrect Event ID. Try again");
                                                                    sc.nextLine();
                                                                }
                                                            }
                                                        }
                                                    } else if (confirmReplyQuery.toLowerCase().equals("No")) {
                                                        validAnswer = true;
                                                        break;
                                                    } else {
                                                        System.out.println("Answer a valid answer");
                                                        sc.nextLine();
                                                    }
                                                }
                                    case 2:
                                            while (!validAnswer) {
                                               for(Queries queries: customer.getQueries()){
                                                   System.out.println("QueryID: " + queries.getQueryID()
                                                   + "Query: " + queries.getDetails());

                                               }
                                                System.out.println("Would you like to reply? Answer YES or NO");
                                                String confirmReplyQuery = sc.nextLine();
                                                if (confirmReplyQuery.toLowerCase().equals("YES")) {
                                                    validAnswer = true;
                                                    System.out.println("Enter reply");
                                                    String replyComplaints = sc.nextLine();
                                                    while (!correctEventID) {
                                                        System.out.println("Enter the query id for the reply");
                                                        int replyQueryID = sc.nextInt();
                                                        for(Queries queries: customer.getQueries()){
                                                            if (replyQueryID == queries.getQueryID()) {
                                                                event_manager.handleQuery(replyQueryID, replyComplaints);
                                                                correctEventID = true;
                                                                break;
                                                            } else {
                                                                System.out.println("Incorrect Event ID. Try again");
                                                                sc.nextLine();
                                                            }
                                                        }
                                                    }
                                                } else if (confirmReplyQuery.toLowerCase().equals("No")) {
                                                    validAnswer = true;
                                                    break;
                                                } else {
                                                    System.out.println("Enter a valid answer");
                                                    sc.nextLine();
                                                }


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
                                        event_manager.getVenueBill();
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
                                        boolean costPLanEventID = false;
                                        while (!costPLanEventID) {
                                            System.out.println("Enter the eventID for the costPlan");
                                            int selectedEventID = sc.nextInt();
                                            for (Cost_Plan newCostplan : finance_manager.getCostPlans()) {
                                                for (EventID eventID1 : eventID) {
                                                    if (selectedEventID != newCostplan.getEventID().getEventID() || eventID1.getEventID() == selectedEventID) {
                                                        System.out.println("Valid Event id.");
                                                        costPLanEventID = true;
                                                        finance_manager.getCostPlans().add(new Cost_Plan(eventID.get(selectedEventID)));
                                                        break;
                                                    }
                                                    if (selectedEventID == newCostplan.getEventID().getEventID()) {
                                                        System.out.println("Event id already has a costplan");
                                                        sc.nextLine();
                                                    } else {
                                                        System.out.println("Event id does not exist try again");
                                                        sc.nextLine();
                                                    }
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
                                                allocateEmployeeID = true;
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
                                        logistics_manager.getLogBill();
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
                                        caterer.generateBill();
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
                            "\n8. Check Balance" + "\n9. Deposit Money" + "\n10. View Profile" + "\n11. Back");
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
                            app.printSeperator();
                            if (customer.getEvents().size()==0){
                                System.out.println("You have not booked any events yet");
                            } else {
                                customer.viewEvents();
                                System.out.println("Enter the event number you want to track");
                                int eventNumber = sc1.nextInt();
                                customer.trackEvent(eventNumber);
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
                            break;
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

                            
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                } while (sub_choice6 != 11);
            }
        } while (choice != 3);
        {
        }
    }



}

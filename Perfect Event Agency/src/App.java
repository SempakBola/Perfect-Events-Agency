import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    public void printSeperator() {
        System.out.println("------------------------------------------------------------");
    }

    public void Interface() { //contains the code for the UI;
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
        Changes changes = new Changes();


        Booking sampleBooking= new Booking();
        sampleBooking.selectPackage(packages, 1);
        sampleBooking.selectVenue(venues, 7);
        sampleBooking.SelectFood(foodSelections, 4);
        Options sampleOptions = new Options();
        sampleBooking.selectOptions(sampleOptions);
        sampleBooking.setAttendees(12);
        sampleBooking.setServiceFee(sampleBooking.ServiceFee());
        System.out.println("Debug: " + sampleBooking.getTotalCost());

        customer.createBooking(customer, sampleBooking, "Debit",
         "Frank", "Ocean", "14 feb 2099","44 random street",21314452 );

        customer.createQuery("test query");
        
        EventID sampleEventID = customer.getEvents().get(0);

        Refund sampleRefund = new Refund(sampleEventID, "Not satisfied");
        customer.addRefund(sampleRefund);

        Complaint sampleComplaint = new Complaint(sampleEventID, "Not good as expected");
        customer.addComplaint(sampleComplaint);
        
        Inspection sampleInspection = new Inspection("27/06/2022", "13:00",sampleEventID.getBooking().getVenue());
        customer.addInspection(sampleInspection);

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
                            //EventManager
                            System.out.println("Welcome to Event Manager Portal");
                            int sub_choice2 = 0;
                            do {
                                //input event manager functions
                                //ENTER CODE HERE. Make changes to the options below if needed
                                System.out.println("1. Handle Complain" + "\n" + "2. Handle Query" + "\n" + "3. Book Venue" + "\n" +
                                        "4. Handle Changes" + "\n" + "5. Track Progress" + "\n" + "6. Update Progress" + "\n7. Generate Bill" + "\n8.Back");
                                sub_choice2 = sc.nextInt();
                                switch (sub_choice2) {

                                    case 1:

                                                //handle complaints code
                                                   customer.viewComplaints(); //uses toString method in the customer class to see all the complants
                                                    System.out.println("Would you like to reply? Answer YES or NO");
                                                    String confrimReplyComplaint = sc.next();
                                                   switch (confrimReplyComplaint.toLowerCase()){ //case-sensitive handling
                                                       case "yes":
                                                           System.out.println("Enter event id");
                                                           int complaintEventID = sc.nextInt();
                                                           sc.nextLine(); //
                                                           List<Complaint> chosenEvent =
                                                                   customer.getComplaints().stream().filter(f->f.getEventID().getEventID() == complaintEventID).collect(Collectors.toList());
                                                           //create a list from the matched event id
                                                            if(!chosenEvent.equals("")){ //if the event id is not null accepts the input
                                                                System.out.println("Enter reply");
                                                                String reply = sc.nextLine();
                                                                event_manager.handleComplaints(complaintEventID,reply); //uses the eventmanager to send complaints
                                                                System.out.println("Complaint reply sent");
                                                            }
                                                           break;
                                                       case "no":
                                                           break;
                                                   }
                                            break;
                                    case 2:
                                        //handle queries code
                                            customer.viewQueries();  //uses toString method in the customer class to see all the queries
                                        System.out.println("Would you like to reply? Answer YES or NO");
                                        String confrimReplyQuery = sc.next();
                                        switch (confrimReplyQuery.toLowerCase()){ //case-sensitive handling
                                            case "yes":
                                                System.out.println("Enter query id");
                                                int queriesEventID = sc.nextInt();
                                                sc.nextLine();
                                                List<Queries> chosenEvent =
                                                        customer.getQueries().stream().filter(f-> f.getQueryID() == queriesEventID).collect(Collectors.toList());
                                                //stores the matched querys based on the query id given
                                                if(!chosenEvent.equals("")){ //if the query id exists ie not null then its accepted
                                                    System.out.println("Enter reply");
                                                    String reply = sc.next();
                                                    event_manager.handleQuery(queriesEventID,reply);
                                                    System.out.println("Query reply sent");
                                                }if(chosenEvent.equals("")) {
                                                System.out.println("Incorrect eventID");
                                            }
                                                break;
                                            case "no":
                                                break;
                                            default:
                                                System.out.println("Incorrect");
                                                break;
                                        }
                                        break;
                                    case 3:
                                        //Book Venue
                                        System.out.println("Enter the event ID to book venue");
                                        int bookVenueEventID = sc.nextInt();
                                        List<EventID> venueEvent = customer.getEvents().stream().filter(f->f.getEventID()==bookVenueEventID).collect(Collectors.toList());
                                        //matches the event id to the booked
                                        if(!venueEvent.equals("")){
                                            event_manager.bookVenue(bookVenueEventID); //uses the event manager method to add to the tasks
                                            System.out.println("venue added to the task");
                                        }else{
                                            System.out.println("Incorrect eventID");
                                        }
                                        break;
                                    case 4:
                                        //Handle Changes
                                        System.out.println("Enter event id for the changes");
                                        int changedEventID = sc.nextInt();
                                        if(changedEventID == changes.getEventID()){ //checks if the event id is stored in the changes class
                                            event_manager.makeChanges(changedEventID); //if valid adds changes to the list of tasks
                                            System.out.println("changes added to tasks");
                                        }
                                        if (changedEventID != changes.getEventID()){ //error handling
                                            System.out.println("event id does not need changes");
                                        }
                                        break;
                                    case 5:
                                        //Track Progress
                                        System.out.println("Enter eventID for the event you want to track");
                                        int trackingEventID = sc.nextInt();
                                        tracker.checkProgress(); //uses the tracking class method to get the list of tasks
                                        break;
                                    case 6:
                                        //Update Progress
                                        tracker.UpdateProgress(sc, customer); //uses the tracker class method to update the progress
                                        break;
                                    case 7:
                                        //Generate Bill
                                        System.out.println("Enter event id for bill");
                                       int billEventID  = sc.nextInt();
                                       event_manager.getVenueBill(billEventID,customer); //uses the eventmanager class method to get the bill

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
                                            int costplancreateEventid = sc.nextInt();
                                            sc.nextLine();
                                            for(Cost_Plan cost_plan: finance_manager.getCostPlans()){
                                                for(EventID eventID1: customer.getEvents()){
                                                    if(costplancreateEventid == eventID1.getEventID() && cost_plan.getEventID().getEventID() != costplancreateEventid){
                                                        //checks if event id exists and no costplan has already been created
                                                        System.out.println("costplan created");
                                                        finance_manager.getCostPlans().add(new Cost_Plan(eventID1)); //if valid creates and new cost plan
                                                        System.out.println(finance_manager.getCostPlans().get(eventID1.getEventID()));
                                                    } else if (cost_plan.getEventID().getEventID() == costplancreateEventid) { //error checking
                                                        System.out.println("Costplan already exist");
                                                    }else{ //error checking
                                                        System.out.println("incorrect event id");
                                                    }
                                                }

                                             }
                                        break;
                                    case 2:
                                        //Change Cost Plan
                                        System.out.println(
                                                "Enter 1 to deleted. Enter 2 to go back");
                                        int changeCostPlanChoice = sc.nextInt();
                                        switch (changeCostPlanChoice){
                                            //assumption: as the all the costplan details are automated the only change can be done is to delete the existing costplan
                                            case 1:
                                                System.out.println("Enter enterID for the cost plan to be delete");
                                                int costplanidChangning = sc.nextInt();
                                                sc.nextLine();
                                                for(Cost_Plan cost_plan: finance_manager.getCostPlans()){
                                                    if(costplanidChangning == cost_plan.getEventID().getEventID()){ //checks if the event id match then the costplan is deleted
                                                        finance_manager.getCostPlans().remove(cost_plan);
                                                    }else {
                                                        System.out.println("Costplan doesnt exist");
                                                    }
                                                }

                                                break;
                                            case 2:
                                                break;
                                        }
                                        break;
                                    case 3:
                                        //Allocate Money
                                            System.out.println("Money is auto-calculated and distributed from the revenue generated. " +
                                                    "\n" + "Enter the employeeID: ");

                                            int allocateEmployeeID = sc.nextInt();
                                            System.out.println("Enter event id from the money is calculated");
                                            int allocatedEventID = sc.nextInt();
                                            if (allocateEmployeeID == employee.getEmployeeID()) { //matches the event id for validation
                                                finance_manager.allocateMoney(allocateEmployeeID,allocatedEventID); //uses the allocate money method to allocate the money to the employees
                                            } if (allocateEmployeeID != employee.getEmployeeID()){ //error handling
                                                System.out.println("Enter valid EmployeeID:"); //
                                            }


                                        break;
                                    case 4:
                                        //Pay Salary
                                            System.out.println("Money is auto-calculated and distributed from the profit generated. " +
                                                    "\n" + "Enter the employeeID: ");
                                            int salaryEmployeeID = sc.nextInt();
                                            if (salaryEmployeeID == employee.getEmployeeID()) {
                                                System.out.println("Enter event id");
                                                int paySalaryEventID = sc.nextInt();
                                                for(EventID eventID1: customer.getEvents()){
                                                    if(paySalaryEventID == eventID1.getEventID()){
                                                        finance_manager.paySalary(salaryEmployeeID,eventID1);
                                                        System.out.println("customer paid");
                                                    }
                                                }
                                                System.out.println("Employee paid");
                                            } if(salaryEmployeeID !=employee.getEmployeeID()) {
                                                System.out.println("Enter valid EmployeeID:");
                                            }
                                        break;
                                    case 5:
                                        //Track Progress
                                        System.out.println("Enter eventID for the event you want to track");
                                        int trackingEventID = sc.nextInt();
                                        tracker.checkProgress();
                                        break;
                                    case 6:
                                        //Update Progress
                                        tracker.UpdateProgress(sc,customer);
                                        break;
                                    case 7:
                                        //Update Packages
                                        System.out.println("Enter package number to change");
                                            int chosenPackage = sc.nextInt();
                                                List<Packages> updatePackages = packages.stream().filter(f->f.getPackage_num() == chosenPackage).collect(Collectors.toList());
                                                //creates a list to filter out the package number to the selected one
                                                if (!updatePackages.equals("")) {
                                                    updatePackages.forEach(Packages::str); //uses the package to string method
                                                    System.out.println("Choose 1 to change Capacity or choose 2 for Details");
                                                    //assumption only two options can be changed for the packages
                                                    int chosenUpdate = sc.nextInt();
                                                    sc.nextLine();
                                                    switch (chosenUpdate) {
                                                        case 1 -> {
                                                            System.out.println("Enter new capacity");
                                                            int newCapacity = sc.nextInt();
                                                            for(Packages updateCapacity: updatePackages){ //updates the package based on the capacity given
                                                                updateCapacity.setCapacity(newCapacity);
                                                            }
                                                            System.out.println("capacity updated");
                                                        }
                                                        case 2 -> {
                                                            System.out.println("Enter new details");  //updates the package based on the details given
                                                            String newDetails = sc.nextLine();
                                                            for(Packages updateDetails: updatePackages){
                                                                updateDetails.setDetails(newDetails);
                                                            }
                                                            System.out.println("details updated");
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Invalid package number try again");
                                                }
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
                                        System.out.println("Enter the eventid to hire music band");
                                        int musicEventID = sc.nextInt();
                                        List<EventID> musicevent = customer.getEvents().stream().filter(f->f.getEventID() == musicEventID).collect(Collectors.toList());
                                        //matches the event id with the given
                                        if(!musicevent.equals("")){
                                            logistics_manager.hireMusicBand((musicEventID)); //if its matched then adds the music task and sets it true
                                            System.out.println("Music Band task added");
                                        }else{
                                            System.out.println("Event id doesnt exist");
                                        }
                                        break;
                                    case 2:
                                        //Hire sound System code:
                                        System.out.println("Enter the eventid to hire sound  system");
                                        int soundEventID = sc.nextInt();
                                        List<EventID> soundevent = customer.getEvents().stream().filter(f->f.getEventID() == soundEventID).collect(Collectors.toList());
                                        //matches the event id with the given for the sound system
                                        if(!soundevent.equals("")){ //if it exists. ie not null
                                            logistics_manager.hireSoundSystem(soundEventID); //adds the task using the method in the logistic manager
                                            System.out.println("Sound system task added");
                                        }else{
                                            System.out.println("Event id doesnt exist");
                                        }
                                        break;
                                    case 3:
                                        //Order Flowers
                                        System.out.println("Enter the eventid to order flowers");
                                        int flowerEventID = sc.nextInt();
                                        List<EventID> flowerevent = customer.getEvents().stream().filter(f->f.getEventID() == flowerEventID).collect(Collectors.toList());
                                        //matches the event id with the given
                                        if(!flowerevent.equals("")){//if it exists. ie not null
                                            logistics_manager.orderFlowers(flowerEventID); //adds the tasks to the flower method in logistic manager class
                                            System.out.println("Flowers task added added");
                                        }else{
                                            System.out.println("Event id doesnt exist");
                                        }
                                        break;
                                    case 4:
                                        //Track Progress
                                        System.out.println("Enter eventID for the event you want to track");
                                        int trackingEventID = sc.nextInt();
                                        tracker.checkProgress();
                                        break;
                                    case 5:
                                        //Update Progress
                                        tracker.UpdateProgress(sc,customer);
                                        break;
                                    case 6:
                                        //Generate Bill
                                        System.out.println("Enter event id for bill");
                                        int billEventID  = sc.nextInt();
                                        logistics_manager.getLogBill(billEventID,customer); //generates the bill from the logistic manager class
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
                                        List<EventID> foodandbevEvent = customer.getEvents().stream().filter(f->f.getEventID() == foodandbevEventID).collect(Collectors.toList());
                                        //matches the event id with the given
                                        if(!foodandbevEvent.equals("")){ //if not null ie exists
                                            caterer.arrangeFoodandBeverages(foodandbevEventID); //adds the task using the caterer class method for food and bev
                                            System.out.println("food and beverages task added");
                                        }else{
                                            System.out.println("Event id doesnt exist");
                                        }
                                        break;
                                    case 2:
                                        //Arrange cutlery
                                        System.out.println("Enter the event ID for the cutlery");
                                        int arrangeCutleryID = sc.nextInt();
                                        List<EventID> arrangecutleryEvent = customer.getEvents().stream().filter(f->f.getEventID() == arrangeCutleryID).collect(Collectors.toList());
                                        if(!arrangecutleryEvent.equals("")){//if not null ie exists
                                            caterer.arrangeCutlery(arrangeCutleryID);//adds the task using the caterer class method for the cutlery
                                            System.out.println("cutlery task added");
                                        }else{
                                            System.out.println("Event id doesnt exist");
                                        }
                                        break;

                                    case 3:
                                        //pick up food
                                        System.out.println("Enter the event ID to pickup food");
                                        int foodpickupEventID = sc.nextInt();
                                        List<EventID> foodpickEvent = customer.getEvents().stream().filter(f->f.getEventID() == foodpickupEventID).collect(Collectors.toList());
                                        if(!foodpickEvent.equals("")){//if not null ie exists
                                            caterer.pickupFood(foodpickupEventID);
                                            System.out.println("pickup food task added");
                                        }else{
                                            System.out.println("Event id doesnt exist");
                                        }

                                    case 4:
                                        //Track Progress
                                        System.out.println("Enter eventID for the event you want to track");
                                        int trackingEventID = sc.nextInt();
                                        tracker.checkProgress();
                                        break;
                                    case 5:
                                        //Update Progress
                                        tracker.UpdateProgress(sc,customer);
                                        break;
                                    case 6:
                                        //Generate Bill
                                        System.out.println("Enter event id for bill");
                                        int billEventID  = sc.nextInt();
                                        caterer.billMenu(billEventID,customer); //uses the bill menu method in the caterer class to generate bill
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
                            if(soundSystem.toLowerCase().equals("y")){
                                option.setIsSoundSystem(true);
                            }
                            System.out.println("Do you want a musical band? (y/n)");
                            String musicalBand=sc1.next();
                            if(musicalBand.toLowerCase().equals("y")){
                                option.setIsHireBand(true);
                            }
                            System.out.println("Do you want flower decorations? (y/n)");
                            String flowers=sc1.next();
                            if(flowers.toLowerCase().equals("y")){
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
                            booking.setServiceFee(booking.ServiceFee());
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
                                        eventID1.getTracker().checkProgress();
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
                            if (customer.viewEvents()){
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
                            if (customer.viewEvents()){
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
                            if(customer.viewEvents()){
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

                    }
                } while (sub_choice6 != 12);
            }
        } while (choice != 3);
        
    }



}

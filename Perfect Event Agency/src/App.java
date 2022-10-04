import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    private static ArrayList<EventID> eventID = new ArrayList<>();
    public void printSeperator() {
        System.out.println("------------------------------------------------------------");
    }

    public static void main(String[]args) { //contains the code for the UI;
        int choice=0;
        //test data
        ArrayList<Venue> venues = new ArrayList<Venue>();
        venues.add(new Venue("The Ballroom", 100, 15000, true));
        venues.add(new Venue("The Grand Hall", 50, 5000, true));
        venues.add(new Venue("The Grand Ballroom", 120, 8000, true));
        venues.add(new Venue("The Westin", 200, 20000, true));
        venues.add(new Venue("The Hilton", 30, 2000, true));
        venues.add(new Venue("The Marriott", 150, 10000, true));
        venues.add(new Venue("The Sheraton", 15, 1000, true));

        ArrayList<FoodSelection> foodSelections = new ArrayList<FoodSelection>();
        foodSelections.add(new FoodSelection("Food Plan A", 1000));
        foodSelections.add(new FoodSelection("Food Plan B", 2000));
        foodSelections.add(new FoodSelection("Food Plan C", 3000));
        foodSelections.add(new FoodSelection("Food Plan D", 4000));

        ArrayList<Packages> packages = new ArrayList<Packages>();
        packages.add(new Packages(1, "Package A FROM $1100",15));
        packages.add(new Packages(2, "Package B FROM $6000 ",50));
        packages.add(new Packages(3, "Package C FROM $11000",150));

        App app = new App();
        Customer customer = new Customer();

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to the Perfect Events Agency\n");
            System.out.println("Choose your role:"+"\n"+"1. Employee"+"\n"+"2. Customer"+"\n3. Exit");
            choice = sc.nextInt();
            app.printSeperator();
            if(choice!=1 && choice!=2){
                System.out.println("Invalid choice");
            }
            //Employee View
            if (choice==1) {

                app.printSeperator();
                System.out.println("Welcome to Employee Portal");
                int sub_choice1=0;
                
                //Choose role
                do {
                    System.out.println("Pick your role:"+"\n"+"1. Event Manager"+"\n"+"2. Finance Manager"+"\n"+"3. Logistics Manager"+"\n4. Caterer");
                    sub_choice1 = sc.nextInt();
                    if(sub_choice1<1 || sub_choice1>4){
                        System.out.println("Invalid choice");
                    }
                    switch (sub_choice1) {
                        case 1:
                            boolean correctEventID = false;
                            boolean validAnswer = false;
                            //EventManager
                            System.out.println("Welcome to Event Manager Portal");
                            int sub_choice2=0;
                           Event_Manager event_manager = new Event_Manager();
                            do {
                                //input event manager functions
                                //ENTER CODE HERE. Make changes to the options below if needed
                                System.out.println("1. Handle Query"+"\n"+"2. Handle Complaints"+"\n"+"3. Book Venue"+"\n"+
                                "4. Handle Changes"+"\n"+"5. Track Progress"+"\n"+"6. Update Progress"+"\n7. Generate Bill"+"\n8.Back");
                                sub_choice2 = sc.nextInt();
                                switch (sub_choice2) {
                                    case 1:

                                        for(EventID event: eventID) {
                                            while (!validAnswer) {
                                                System.out.println("Event id: (" + event.getEventID() + ") Queries:  " + event.getQueries());
                                                System.out.println("Would you like to reply? Answer YES or NO");
                                                String confirmReplyQuery = sc.nextLine();
                                                if (confirmReplyQuery.toLowerCase().equals("YES")) {
                                                    validAnswer =true;
                                                    System.out.println("Enter reply");
                                                    String replyQuery = sc.nextLine();

                                                    while (!correctEventID) {
                                                        System.out.println("Enter the event id for the reply");
                                                        int replyEventID = sc.nextInt();
                                                        if (replyEventID == event.getEventID()) {
                                                            event_manager.handleQuery(replyEventID, replyQuery);
                                                            correctEventID = true;
                                                            break;
                                                        } else {
                                                            System.out.println("Incorrect Event ID. Try again");
                                                            sc.nextLine();
                                                        }
                                                    }
                                                }

                                               else if (confirmReplyQuery.toLowerCase().equals("No")) {
                                                    validAnswer =true;
                                                    break;
                                                }
                                               else{
                                                    System.out.println("Answer a valid answer");
                                                    sc.nextLine();
                                                }
                                            }
                                        }
                                    case 2:
                                        for(EventID event: eventID) {
                                            while (!validAnswer) {
                                                System.out.println("Event id: (" + event.getEventID() + ") Complaints:  " + event.getComplaint());
                                                System.out.println("Would you like to reply? Answer YES or NO");
                                                String confirmReplyQuery = sc.nextLine();
                                                if (confirmReplyQuery.toLowerCase().equals("YES")) {
                                                    validAnswer = true;
                                                    System.out.println("Enter reply");
                                                    String replyComplaints = sc.nextLine();
                                                    while (!correctEventID) {
                                                        System.out.println("Enter the event id for the reply");
                                                        int replyEventID = sc.nextInt();
                                                        if (replyEventID == event.getEventID()) {
                                                            event_manager.handleComplaints(replyEventID, replyComplaints);
                                                            correctEventID = true;
                                                            break;
                                                        } else {
                                                            System.out.println("Incorrect Event ID. Try again");
                                                            sc.nextLine();
                                                        }
                                                    }
                                                } else if (confirmReplyQuery.toLowerCase().equals("No")) {
                                                    validAnswer = true;
                                                    break;
                                                }else{
                                                    System.out.println("Enter a valid answer");
                                                    sc.nextLine();
                                                }


                                            }
                                        }
                                    case 3:
                                        //Book Venue
                                        HashMap<Integer,String> displayVenue = new HashMap<>();
                                        boolean correctNumber = false;
                                        int count = 1;
                                        for(Venue venue: venues){
                                            displayVenue.put(count,venue.getName());
                                            System.out.println(count + ". "+ venue.getName());
                                            count++;
                                        }
                                        while (!correctNumber) {
                                            System.out.println("\n" + "Select venue based on number: ");
                                            int chosenVenueNumber = sc.nextInt();
                                            if(displayVenue.containsKey(chosenVenueNumber)){
                                                correctNumber = true;
                                                event_manager.bookVenue(displayVenue.get(chosenVenueNumber));
                                                break;
                                            }else{
                                                System.out.println("Enter a valid number");
                                                sc.nextInt();
                                            }
                                        }
                                        break;
                                    case 4:
                                        //Handle Changes
                                        //ENTER CODE HERE
                                        break;
                                    case 5:
                                        //Track Progress
                                        //ENTER CODE HERE
                                        break;
                                    case 6:
                                        //Update Progress
                                        //ENTER CODE HERE
                                        break;
                                    case 7:
                                        //Generate Bill
                                        //ENTER CODE HERE
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                }
                            } while (sub_choice2!=8);
                            break;
                        case 2:
                            //FinanceManager
                            System.out.println("Welcome to Finance Manager Portal");
                            int sub_choice3=0;
                            do {
                                System.out.println("1. Create Cost Plan"+"\n"+"2. Change Cost Plan"+"\n"+"3. Allocate Money"+"\n"+
                                "4. Pay Salary"+"\n"+"5. Track Progress"+"\n"+"6. Update Progress"+"\n7. Update Packages"+"\n8. Back");
                                sub_choice3 = sc.nextInt();
                                switch (sub_choice3) {
                                    case 1:
                                        //Create Cost Plan
                                        //ENTER CODE HERE
                                        System.out.println("Create Cost Plan");
                                        break;
                                    case 2:
                                        //Change Cost Plan
                                        //ENTER CODE HERE
                                        break;
                                    case 3:
                                        //Allocate Money
                                        //ENTER CODE HERE
                                        break;
                                    case 4:
                                        //Pay Salary
                                        //ENTER CODE HERE
                                        break;
                                    case 5:
                                        //Track Progress
                                        break;
                                    case 6:
                                        //Update Progress
                                        //ENTER CODE HERE
                                        break;
                                    case 7:
                                        //Update Packages
                                        //ENTER CODE HERE
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                } 
                            } while (sub_choice3!=8);
                            break;
                        case 3:
                            //LogisticsManager
                            System.out.println("Welcome to Logistics Manager Portal");
                            int sub_choice4=0;
                            do {
                                System.out.println("1. Hire Musical Band"+"\n"+"2. Hire Sound System"+"\n"+"3. Order Flowers"+"\n"+
                                "4. Track Progress"+"\n"+"5. Update Progress"+"\n"+"6. Generate Bill"+"\n7. Back");
                                sub_choice4 = sc.nextInt();
                                switch (sub_choice4) {
                                    case 1:
                                        //Hire Musical Band
                                        //ENTER CODE HERE
                                        System.out.println("Create Logistics Plan");
                                        break;
                                    case 2:
                                        //Hire Sound System
                                        //ENTER CODE HERE
                                        break;
                                    case 3:
                                        //Order Flowers
                                        //ENTER CODE HERE
                                        break;
                                    case 4:
                                        //Track Progress
                                        //ENTER CODE HERE
                                        break;
                                    case 5:
                                        //Update Progress
                                        //ENTER CODE HERE
                                        break;
                                    case 6:
                                        //Generate Bill
                                        //ENTER CODE HERE
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                } 
                            } while (sub_choice4!=7);
                            break;
                        case 4:
                            //Caterer
                            System.out.println("Welcome to Caterer Portal");
                            int sub_choice5=0;
                            do {
                                System.out.println("1. Arrange Food and Beverage"+"\n"+
                                "2. Track Progress"+"\n"+"3. Update Progress"+"\n"+"4. Generate Bill"+"\n5. Back");
                                sub_choice5 = sc.nextInt();
                                switch (sub_choice5) {
                                    case 1:
                                        //Arrange Food and Beverage
                                        //ENTER CODE HERE
                                        System.out.println("Create Menu");
                                        break;
                                    case 2:
                                        //Track Progress
                                        //ENTER CODE HERE
                                        break;
                                    case 3:
                                        //Update Progress
                                        //ENTER CODE HERE
                                        break;
                                    case 4:
                                        //Generate Bill
                                        //ENTER CODE HERE
                                        break;
                                    default:
                                        System.out.println("Invalid choice");
                                        break;
                                } 
                            } while (sub_choice5!=5);
                            break;
                    
                        default:
                            break;
                    }
                    
                } while (sub_choice1<1 || sub_choice1>4);
            } else if (choice==2) {
                System.out.println("Welcome to Customer Portal");
                int sub_choice6=0;
                Scanner sc1 = new Scanner(System.in);
                do {
                    System.out.println("\n1. View Packages"+"\n2. Book Event"+"\n3. Track Progress"+"\n4. Create Query"+
                    "\n5. Make Complaint"+"\n6. Request Refund and Cancel"+"\n7. Change Booking"+
                    "\n8. Check Balance"+"\n9. Deposit Money"+"\n10. View Profile"+"\n11. Back");
                    sub_choice6 = sc1.nextInt();
                    switch (sub_choice6) {
                        case 1:
                            //View Packages
                            //ENTER CODE HERE
                            app.printSeperator();
                            for (int i = 0; i < packages.size(); i++) {
                                packages.get(i).str();
                            }
                            break;
                        case 2:
                            //Book Event
                            //ENTER CODE HERE
                            Booking booking = new Booking();
                            //selecting package
                            app.printSeperator();
                            for (int i = 0; i < packages.size(); i++) {
                                packages.get(i).str();
                            }
                            System.out.println("Enter the package number you want to book");
                            booking.selectPackage(packages.get(sc1.nextInt()-1));
                            
                            app.printSeperator();
                            //selecting venue
                            System.out.println("Enter the number of guests: ");
                            int numberOfGuests = sc1.nextInt();
                            for (int i=0; i<venues.size(); i++){
                                if (venues.get(i).getCapacity()>=numberOfGuests && venues.get(i).isAvailability()==true){
                                    System.out.println(i+1);
                                    customer.viewVenue(venues.get(i));
                                }
                            }
                            System.out.println("Enter the venue number you want to book");
                            booking.selectVenue(venues.get(sc1.nextInt()-1));

                            app.printSeperator();
                            //enter food selection
                            for (int i=0;i<foodSelections.size();i++){
                                System.out.println(i+1);
                                customer.viewFood(foodSelections.get(i));
                            }
                            System.out.println("Enter the food number you want to book");
                            booking.foodSelection(foodSelections.get(sc1.nextInt()-1));

                            app.printSeperator();
                            //selecting options
                            Options option = new Options();
                            System.out.println("Do you want to hire a band? (Y/N)");
                            if (sc.next().toUpperCase().equals("Y")){
                                option.setIsHireBand(true);
                            }

                            System.out.println("Do you want to have flower decorations? (Y/N)");
                            if (sc.next().toUpperCase().equals("Y")){
                                option.setIsFlowerDecoration(true);
                            }

                            System.out.println("Do you want to have sound system? (Y/N)");
                            if (sc.next().toUpperCase().equals("Y")){
                                option.setIsSoundSystem(true);
                            }

                            app.printSeperator();

                            booking.selectOptions(option);
                            //to ensure that the code doesnt skip the input
                            sc.nextLine();
                            //entering customer details
                            System.out.println("Enter your first name: ");
                            customer.setFirstName(sc.nextLine());
                            System.out.println("Enter your last name: ");
                            customer.setLastName(sc.nextLine());
                            System.out.println("Enter your dob: ");
                            customer.setDob(sc.nextLine());
                            System.out.println("Enter your address: ");
                            customer.setAddress(sc.nextLine());

                            //entering payment details
                            System.out.println("Select your payment method: \n1. Credit card\n 2.Debit card\n 3. Net banking (Enter String)" );
                            int payment_choice=sc.nextInt();
                            String paymentMethod="";
                            if (payment_choice==1){
                                paymentMethod="Credit card";
                            } else if (payment_choice==2){
                                paymentMethod="Debit card";
                            } else if (payment_choice==3){
                                paymentMethod="Net banking";
                            }
                            app.printSeperator();
                            customer.createBooking(customer, booking, paymentMethod);
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
                            if (customer.getEvents().size()!=0){
                                customer.viewEvents();
                                System.out.println("Enter Event ID: ");
                                int eventID = sc1.nextInt();
                                for (int i=0; i<customer.getEvents().size(); i++){
                                if (customer.getEvents().get(i).getEventID()==eventID){
                                    System.out.println("Enter your complaint: ");
                                    sc.nextLine();
                                    customer.makeComplaint(customer.getEvents().get(i), sc1.nextLine());
                                }
                            }
                            
                            }
                            else{
                                System.out.println("You have not booked any events yet");
                            }
                            break;
                        case 6:
                            //Request Refund and Cancel
                            //ENTER CODE HERE
                            app.printSeperator();
                            if (customer.getEvents().size()!=0){
                                customer.viewEvents();
                                System.out.println("Enter Event ID: ");
                                int eventID1 = sc1.nextInt();
                                sc.nextLine();
                                String details =sc1.nextLine();
                                for (int i=0; i<customer.getEvents().size(); i++){
                                if (customer.getEvents().get(i).getEventID()==eventID1){
                                    customer.requestRefund(customer,customer.getEvents().get(i), details);
                                }
                            }
                            }
                            else{
                                System.out.println("You have no events to cancel");
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
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                } while (sub_choice6!=11);
            }
        } while (choice!=3);{
            
        }
                
    }



}

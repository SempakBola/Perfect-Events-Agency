import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[]args) { //contains the code for the UI;
        int choice=0;
        //test data
        ArrayList<Venue> venues = new ArrayList<Venue>();
        venues.add(new Venue("The Ballroom", 1000, 20000, true));
        venues.add(new Venue("The Grand Hall", 500, 10000, true));
        venues.add(new Venue("The Grand Ballroom", 1000, 25000, true));
        venues.add(new Venue("The Westin", 1200, 15000, false));

        ArrayList<FoodSelection> foodSelections = new ArrayList<FoodSelection>();
        foodSelections.add(new FoodSelection("Food Plan A", 1000));
        foodSelections.add(new FoodSelection("Food Plan B", 2000));
        foodSelections.add(new FoodSelection("Food Plan C", 3000));
        foodSelections.add(new FoodSelection("Food Plan D", 4000));

        ArrayList<Packages> packages = new ArrayList<Packages>();
        packages.add(new Packages("Package A", 1000));
        packages.add(new Packages("Package B", 2000));
        packages.add(new Packages("Package C", 3000));
        packages.add(new Packages("Package D", 4000));

        
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to the Perfect Events Agency\n");
            System.out.println("Choose your role:"+"\n"+"1. Employee"+"\n"+"2. Customer"+"\n3. Exit");
            choice = sc.nextInt();
            if(choice!=1 && choice!=2){
                System.out.println("Invalid choice");
            }
            //Employee View
            if (choice==1) {
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
                            //EventManager
                            System.out.println("Welcome to Event Manager Portal");
                            int sub_choice2=0;
                            do {
                                //input event manager functions
                                //ENTER CODE HERE. Make changes to the options below if needed
                                System.out.println("1. Handle Query"+"\n"+"2. Handle Complaints"+"\n"+"3. Book Venue"+"\n"+
                                "4. Handle Changes"+"\n"+"5. Track Progress"+"\n"+"6. Update Progress"+"\n7. Generate Bill"+"\n8.Back");
                                sub_choice2 = sc.nextInt();
                                switch (sub_choice2) {
                                    case 1:
                                        //Handle Query
                                        //ENTER CODE HERE
                                        System.out.println("Handle Query");
                                        break;
                                    case 2:
                                        //Handle Complaints
                                        //ENTER CODE HERE
                                        break;
                                    case 3:
                                        //Book Venue
                                        //ENTER CODE HERE
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
                                        //ENTER CODE HERE
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
                Customer c = new Customer();
                do {
                    System.out.println("\n1. View Packages"+"\n2. Book Event"+"\n3. Track Progress"+"\n4. Create Query"+
                    "\n5. Make Complaint"+"\n6. Request Refund and Cancel"+"\n7. Change Booking"+"\n8. RETURN");
                    sub_choice6 = sc1.nextInt();
                    switch (sub_choice6) {
                        case 1:
                            //View Packages
                            //ENTER CODE HERE
                            for (int i = 0; i < packages.size(); i++) {
                                System.out.println(i+1);
                                c.viewPackage(packages.get(i));
                            }
                            break;
                        case 2:
                            //Book Event
                            //ENTER CODE HERE
                            Booking b = new Booking();
                            //selecting package
                            for (int i = 0; i < packages.size(); i++) {
                                System.out.println(i+1);
                                c.viewPackage(packages.get(i));
                            }
                            System.out.println("Enter the package number you want to book");
                            b.selectPackage(packages.get(sc1.nextInt()-1));
                            
                            //selecting venue
                            System.out.println("Enter the number of guests: ");
                            int numberOfGuests = sc1.nextInt();
                            for (int i=0; i<venues.size(); i++){
                                if (venues.get(i).getCapacity()==numberOfGuests && venues.get(i).isAvailability()){
                                    System.out.println(i+1);
                                    c.viewVenue(venues.get(i));
                                }
                                else{
                                    System.out.println("No venue available");
                                }
                            }
                            System.out.println("Enter the venue number you want to book");
                            b.selectVenue(venues.get(sc1.nextInt()-1));

                            
                            //enter food selection
                            for (int i=0;i<foodSelections.size();i++){
                                System.out.println(i+1);
                                c.viewFood(foodSelections.get(i));
                            }
                            System.out.println("Enter the food number you want to book");
                            b.foodSelection(foodSelections.get(sc1.nextInt()-1));

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

                            b.selectOptions(option);

                            


                            break;
                        case 3:
                            //Track Progress
                            //ENTER CODE HERE
                            break;
                        case 4:
                            //Create Query
                            //ENTER CODE HERE
                            break;
                        case 5:
                            //Make Complaint
                            //ENTER CODE HERE
                            break;
                        case 6:
                            //Request Refund and Cancel
                            //ENTER CODE HERE
                            break;
                        case 7:
                            //Change Booking
                            //ENTER CODE HERE
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                } while (sub_choice6!=8);
            }
        } while (choice!=3);{
            
        }
                
    }



}

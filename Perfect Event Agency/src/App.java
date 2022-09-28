import java.util.Scanner;

public class App {
    public App() { //empty constructor to call the interface method in the driver class
    }

    public void Interface() { //contains the code for the UI;
        int choice=0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to the Perfect Events Agency\n");
            System.out.println("Choose your role:"+"\n"+"1. Employee"+"\n"+"2. Customer");
            choice = sc.nextInt();
            if(choice!=1 && choice!=2){
                System.out.println("Invalid choice");
            }
        } while (choice!=1 && choice!=2);{
            //Employee View
            if (choice==1) {
                System.out.println("Welcome to Employee Portal");
                int sub_choice1=0;
                //Choose role
                do {
                    System.out.println("Pick your role:"+"\n"+"1. Event Manager"+"\n"+"2. Finance Manager"+"\n"+"3. Logistics Manager"+"\n4. Caterer");
                    Scanner sc = new Scanner(System.in);
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
                                "4. Handle Changes"+"\n"+"5. Track Progress"+"\n"+"6. Update Progress"+"\n7. Generate Bill");
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
                            } while (sub_choice2<1 || sub_choice2>7);
                            break;
                        case 2:
                            //FinanceManager
                            System.out.println("Welcome to Finance Manager Portal");
                            int sub_choice3=0;
                            do {
                                System.out.println("1. Create Cost Plan"+"\n"+"2. Change Cost Plan"+"\n"+"3. Allocate Money"+"\n"+
                                "4. Pay Salary"+"\n"+"5. Track Progress"+"\n"+"6. Update Progress"+"\n7. Update Packages");
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
                            } while (sub_choice3<1 || sub_choice3>7);
                            break;
                        case 3:
                            //LogisticsManager
                            System.out.println("Welcome to Logistics Manager Portal");
                            int sub_choice4=0;
                            do {
                                System.out.println("1. Hire Musical Band"+"\n"+"2. Hire Sound System"+"\n"+"3. Order Flowers"+"\n"+
                                "4. Track Progress"+"\n"+"5. Update Progress"+"\n"+"6. Generate Bill");
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
                            } while (sub_choice4<1 || sub_choice4>6);
                            break;
                        case 4:
                            //Caterer
                            System.out.println("Welcome to Caterer Portal");
                            int sub_choice5=0;
                            do {
                                System.out.println("1. Arrange Food and Beverage"+"\n"+
                                "2. Track Progress"+"\n"+"3. Update Progress"+"\n"+"4. Generate Bill");
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
                            } while (sub_choice5<1 || sub_choice5>4);
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
                    "\n5. Make Complaint"+"\n6. Request Refund and Cancel"+"\n7. Change Booking");
                    sub_choice6 = sc1.nextInt();
                    switch (sub_choice6) {
                        case 1:
                            //View Packages
                            //ENTER CODE HERE
                            System.out.println("View Packages");
                            break;
                        case 2:
                            //Book Event
                            //ENTER CODE HERE
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
                } while (sub_choice6<1 || sub_choice6>7);
            }
        }
                
    }



}

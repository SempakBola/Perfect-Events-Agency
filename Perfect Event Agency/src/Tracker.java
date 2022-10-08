import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tracker {

    Logistics_Manager logistics_manager = new Logistics_Manager();
    Event_Manager event_manager = new Event_Manager();
    Caterer caterer = new Caterer();
    Customer customer = new Customer();

    private static final ArrayList<String> tasks = new ArrayList<>();


    private static final ArrayList<String> completedTasks = new ArrayList<>();


    Tracker(){

    }

    public static Tracker getTracker(){
        return new Tracker();
    }

    private ArrayList<String> tasks(int eventID){ //contains all the task needed by all the manager
        for (EventID eventID1: customer.getEvents()){
            if(eventID == eventID1.getEventID()){
                ArrayList<String> eventManagerTasks = event_manager.getEventManagerTasks().get(eventID);
                ArrayList<String> catererTasks = caterer.getCatererTask().get(eventID);
                ArrayList<String> logisticManagerTasks = logistics_manager.getLogisticManagerTasks().get(eventID);
                tasks.addAll(eventManagerTasks);
                tasks.addAll(catererTasks);
                tasks.addAll(logisticManagerTasks);
            }
        }

        return tasks;
    }


    public int AvailableTask(int EventID){
        return tasks(EventID).size();
    }

    public int CompletedTask(){return completedTasks.size();}


    public void taskRemover(int eventID, String completedTask) {
        if (AvailableTask(eventID) == 0 && CompletedTask() == 0) {
            System.out.println("Tasks have not started");
        }
        if(AvailableTask(eventID) == 0 && CompletedTask() > 0){
            System.out.println("All tasks completed");
        }
        else {
            tasks(eventID).remove(completedTask);
            completedTasks.add(completedTask);

        }
    }
        public void checkProgress (int eventID) {
            if (AvailableTask(eventID) == 0 && CompletedTask() == 0) {
                System.out.println("Tasks have not started");
            }else {
                System.out.println("Number of outstanding tasks: "+ AvailableTask(eventID) +
                        " Number of completed tasks" + CompletedTask());
                System.out.println("Percentage Completed: " + (CompletedTask()/AvailableTask(eventID)) * 100);
            }
        }


        public void UpdateProgress (int EventID, Scanner sc){
            boolean validEventID = false;
            while (!validEventID) {
                System.out.println("Enter the event ID for the task to be removed ");
                int selectedEventID = sc.nextInt();
                for (EventID eventID: customer.getEvents()) {
                    if (selectedEventID == eventID.getEventID()) {
                        validEventID = true;
                        System.out.println("Enter  the task to be removed ");
                        String removeTask = sc.nextLine();
                        taskRemover(selectedEventID, removeTask);
                        checkProgress(EventID);
                        break;
                    } else {
                        System.out.println("Please select a valid task");
                    }

                }
            }
        }


    }



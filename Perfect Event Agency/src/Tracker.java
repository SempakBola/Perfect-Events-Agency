import java.util.*;
import java.util.stream.Collectors;

public class Tracker {

    Logistics_Manager logistics_manager = new Logistics_Manager();
    Event_Manager event_manager = new Event_Manager();
    Caterer caterer = new Caterer();

    Customer customer = new Customer();


    Tracker(){

    }

    public static Tracker getTracker(){
        return new Tracker();
    }

    private HashMap<Integer, String> tasks(){
        caterer.getCatererTask().forEach((k, v) -> logistics_manager.getLogisticManagerTasks().merge(k, v, String::concat));
        event_manager.getEventManagerTasks().forEach((k, v) -> caterer.getCatererTask().merge(k, v, String::concat));
        return new HashMap<>(event_manager.getEventManagerTasks());
    }


    public int AvailableTask(){
        return tasks().size();
    }


    public void taskRemover(Integer eventID, String taskName) {
        if (AvailableTask() == 0) {
            System.out.println("All tasks are completed");
        } else {
            for (EventID eventID1 : customer.getEvents()) {
                if (eventID == eventID1.getEventID()) {
                    tasks().remove(eventID, taskName);
                } else {
                    System.out.println("Incorrect ID");
                }
            }

        }
    }
        public void checkProgress () {
            int totalnumberofTasks = 6;
            if (logistics_manager.optionalserviceused()) {
                totalnumberofTasks++;
            }
            int completionPercentage = (AvailableTask() / totalnumberofTasks) * 100;
            System.out.println("number of tasks remaining " + AvailableTask() + ". " + completionPercentage + "% is completed");
        }


        public void UpdateProgress (Scanner sc){
            boolean validEventID = false;
            while (!validEventID) {
                System.out.println("Enter the event ID for the task to be removed ");
                int selectedEventID = sc.nextInt();
                for (Map.Entry<Integer, String> entry : tasks().entrySet()) {
                    Integer key = entry.getKey();
                    if (selectedEventID == key) {
                        validEventID = true;
                        System.out.println("Enter  the task to be removed ");
                        String removeTask = sc.nextLine();
                        taskRemover(selectedEventID, removeTask);
                        checkProgress();
                        break;
                    } else {
                        System.out.println("Please select a valid task");
                    }

                }
            }
        }


    }



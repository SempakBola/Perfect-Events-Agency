import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private HashMap<Integer, ArrayList<String>> tasks(){ //contains all the task needed by all the manager
        /* Map<Integer, ArrayList<String>> merge1 = //merges the event manager task and caterer task together to create a new map(Merge1).
                 //code from:https://www.baeldung.com/java-hashmap-remove-entry
                Stream.concat(event_manager.getEventManagerTasks().entrySet().stream(), caterer.getCatererTask().entrySet().stream())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (v1, v2) -> v1+","+v2));
        Map<Integer, ArrayList<String>> merge2 = //merges the first map with the logistics manager
                Stream.concat(logistics_manager.getLogisticManagerTasks().entrySet().stream(), merge1.entrySet().stream())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (v1, v2) -> v1+","+v2));

         return (HashMap<Integer, ArrayList<String>>) merge2;*/
    }


    public int AvailableTask(){
    }


    public void taskRemover(Integer eventID, String replaceTask) {
        if (AvailableTask() == 0) {
            System.out.println("All tasks are completed");
        } else {
            for (EventID eventID1 : customer.getEvents()) {
                if (eventID == eventID1.getEventID()) {
                    String oldTask = tasks().get(eventID);
                    String newTasks = oldTask.replace(replaceTask,"");
                    tasks().put(eventID,newTasks);
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



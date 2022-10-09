import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class taskSetter { //used to set the task into the hashmap for all the managers

    //utility class for redundant code


    public taskSetter() {
    }

    public void setter(int eventID, String[] tasks, HashMap<Integer, ArrayList<String>> hashMap) { //utility method
        //based on the event id adds tasks to a specific hashmap
        Customer customer = new Customer();
        ArrayList<String> allTasks = new ArrayList<>(Arrays.asList(tasks));
        List<EventID> list = customer.getEvents().stream().filter(f->f.getEventID() == eventID).collect(Collectors.toList());
        //used stream for simplicity to search if the entered event id matches the existing event id.
            if (!list.equals(""))//checks if there is an event id. If an event id exist then the result won't be an empty string
                {
                hashMap.put(eventID, allTasks);
            }else {
                System.out.println("incorrect eventID");
            }
    }
}

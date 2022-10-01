import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {

    private int remainingTasks;
    private final String[] tasksNames = {"Book event", "Book venue", "Choose menu", "Enter Details","Pay for Booking"};
    private final ArrayList<String> tasks = new ArrayList<>();
    Logistics_Manager logistics_manager = new Logistics_Manager();


    private Tracker(){

    }

    public static Tracker getTracker(){
        return new Tracker();
    }


    public int AvailableTask(){

        ArrayList<String> tasks = new ArrayList<>(Arrays.asList(tasksNames));
        if(logistics_manager.optionalserviceused()){
            tasks.add("Book optional service");
        }
        remainingTasks = tasks.size();

        return remainingTasks;
    }


    public void updateProgress(String taskName){

        if(remainingTasks == 0){
            System.out.println("All tasks are completed");
        }else{
            tasks.remove(taskName);
        }

    }
    public void checkProgress(){
        int totalnumberofTasks = 6;
        if(logistics_manager.optionalserviceused()){
            totalnumberofTasks++;
        }
        int completionPercentage = (AvailableTask()/totalnumberofTasks)*100;
        System.out.println("number of tasks remaining "+ AvailableTask() + ". " + completionPercentage + "% is completed");
    }
}

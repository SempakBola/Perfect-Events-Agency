import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tracker {

    private int remainingTasks;
    private final String[] tasksNames = {"Book event", "Book venue", "Choose menu", "Enter Details","Pay for Booking"};
    Logistics_Manager logistics_manager = new Logistics_Manager();
    private ArrayList<String> tasks = new ArrayList<>(Arrays.asList(tasksNames));


    Tracker(){

    }

    public static Tracker getTracker(){
        return new Tracker();
    }


    public int AvailableTask(){


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

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

    public  void UpdateProgress(Scanner sc) {
        boolean validTask = false;
        while (!validTask) {
            System.out.println("Which task would you like to remove: ");
            String removeTask = sc.nextLine();
            for (String checkTracker : getTasks()) {
                if (removeTask == checkTracker) {
                    updateProgress(removeTask);
                    checkProgress();
                    validTask = true;
                    break;
                } else {
                    System.out.println("Please select a valid task");
                }

            }
        }
    }
}

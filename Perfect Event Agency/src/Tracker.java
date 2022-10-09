import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tracker { //class used to track the progress of the tasks

    Logistics_Manager logistics_manager = new Logistics_Manager();
    Event_Manager event_manager = new Event_Manager();
    Caterer caterer = new Caterer();
    Customer customer = new Customer();

    private   ArrayList<String> tasks = new ArrayList<>(); //arraylist of all available tasks
    private   ArrayList<String> completedTasks = new ArrayList<>(); //arraylist of all completed tasks


    Tracker(){ //empty constructor

    }

    private ArrayList<String> tasks(int eventID,Customer customer){ //contains all the task needed by all the manager
            List<EventID> listofTasks = customer.getEvents().stream().filter(f->f.getEventID() == eventID).toList();
            //matches the event id to existing event id.
            if(!listofTasks.equals("")){ //if the event id exist then the hashmaps are stored into the arraylist based on the event id
                ArrayList<String> eventManagerTasks = Event_Manager.getEventManagerTasks().get(eventID);
                ArrayList<String> catererTasks = Caterer.getCatererTask().get(eventID);
                ArrayList<String> logisticManagerTasks = Logistics_Manager.getLogisticManagerTasks().get(eventID);
                //makes sure null is accepted as some arraylist won't have task added
                Optional.ofNullable(eventManagerTasks).ifPresent(tasks::addAll);
                Optional.ofNullable(catererTasks).ifPresent(tasks::addAll);
                Optional.ofNullable(logisticManagerTasks).ifPresent(tasks::addAll);
            }

        return tasks;
    }


    public int AvailableTask(int EventID,Customer customer){ //gets the size of all available task
        List<String> uniquetasks = tasks(EventID,customer).stream().distinct().toList();
        //if task added multiple times does not inflate the arraylist
        return uniquetasks.size();
    }

    public int CompletedTask(){return completedTasks.size();} //gets the size of all completed task


    public void taskRemover(int eventID, String completedTask,Customer customer) { //removes task method based on eventid and taskname
        if (AvailableTask(eventID,customer) == 0 && CompletedTask() == 0) {
            //makes sure that both completed task and available task have been used in order to remove task
            System.out.println("Tasks have not started");
        }
       else if(AvailableTask(eventID,customer) == 0 && CompletedTask() > 0){
           //if completed task are more than 0 and available task are finished means that all task completed
            System.out.println("All tasks completed");
        }
        else {
            tasks(eventID,customer).remove(completedTask);
            completedTasks.add(completedTask);
            //when the task is removed from the available, it is simultaneously added to completed
        }
    }
        public void checkProgress (int eventID,Customer customer) { //method that check the progress based of the event id
            if (AvailableTask(eventID,customer) == 0 && CompletedTask() == 0) {
                System.out.println("Tasks have not started");

            }
            else if (AvailableTask(eventID,customer) == 0 && CompletedTask() > 0){
                    System.out.println("All tasks completed");
            }
            else {
                System.out.println("Number of outstanding tasks: " + AvailableTask(eventID,customer) +
                        " Number of completed tasks " + CompletedTask());
                    System.out.println("Percentage completed: " + (CompletedTask() / AvailableTask(eventID,customer)) * 100 + "%");
            }
        }


        public void UpdateProgress (Scanner sc, Customer customer){ //utility method that is used multiple times in the app.java main method
                System.out.println("Enter the event ID for the task to be removed ");
                int selectedEventID = sc.nextInt();
                List<EventID> listofTasks = customer.getEvents().stream().filter(f->f.getEventID() == selectedEventID).toList();
            if (listofTasks != null) {
                System.out.println("Enter task to remove");
                String removeTask = sc.next();
                taskRemover(selectedEventID, removeTask,customer); //uses the task remover method to update progress
            } else if (!listofTasks.equals("")) {
                System.out.println("Enter task to remove");
                String removeTask = sc.nextLine();
                taskRemover(selectedEventID, removeTask,customer); //uses the task remover method to update progress
            } else {
                System.out.println("Incorrect id");
            }

        }

        //getter and setters

    public  ArrayList<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

    public  ArrayList<String> getCompletedTasks() {
        return completedTasks;
    }

    public  void setCompletedTasks(ArrayList<String> completedTasks) {
        this.completedTasks = completedTasks;
    }



    //to string method
    @Override
    public String toString() {
        return "Tracker{" +
                "tasks=" + tasks + "\n" +
                '}';
    }
}



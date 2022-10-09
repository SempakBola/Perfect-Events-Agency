import java.util.*;
import java.util.stream.Collectors;

public class Tracker { //class used to track the progress of the tasks


    private   ArrayList<String> tasks = new ArrayList<>(); //arraylist of all available tasks
    private   ArrayList<String> completedTasks = new ArrayList<>(); //arraylist of all completed tasks


    Tracker(){ //empty constructor

    }

    private ArrayList<String> tasks(int eventID,Customer customer){ //contains all the task needed by all the manager
            List<EventID> listofTasks = customer.getEvents().stream().filter(f->f.getEventID() == eventID).collect(Collectors.toList());
            //matches the event id to existing event id.
            if(!listofTasks.equals("")){ //if the event id exist then the hashmaps are stored into the arraylist based on the event id
                ArrayList<String> eventManagerTasks = Event_Manager.getEventManagerTasks().get(eventID);
                ArrayList<String> catererTasks = Caterer.getCatererTask().get(eventID);
                ArrayList<String> logisticManagerTasks = Logistics_Manager.getLogisticManagerTasks().get(eventID);
                //makes sure null is accepted as some arraylist won't have task added
                Optional.ofNullable(eventManagerTasks).ifPresent(tasks::addAll);
                Optional.ofNullable(catererTasks).ifPresent(tasks::addAll);
                Optional.ofNullable(logisticManagerTasks).ifPresent(tasks::addAll);

                //this section removes all duplicate values and reads them to the tasks arraylist
                Set<String> set = new HashSet<>(tasks);
                tasks.clear();
                tasks.addAll(set);
            }

        return tasks;
    }


    public int AvailableTask(){ //gets the size of all available task
        return tasks.size();
    }

    public int CompletedTask(){return completedTasks.size();} //gets the size of all completed task


    public void taskRemover(int eventID, String completedTask,Customer customer) { //removes task method based on eventid and taskname
        if (AvailableTask() == 0 && CompletedTask() == 0) {
            //makes sure that both completed task and available task have been used in order to remove task
            System.out.println("Tasks have not started");
        }
       else if(AvailableTask() == 0 && CompletedTask() > 0){
           //if completed task are more than 0 and available task are finished means that all task completed
            System.out.println("All tasks completed");
        }
        else {
            tasks(eventID,customer).remove(completedTask);
            completedTasks.add(completedTask);
            //when the task is removed from the available, it is simultaneously added to completed
        }
    }
        public void checkProgress () { //method that check the progress based of the event id
            if (AvailableTask() == 0 && CompletedTask() == 0) {
                System.out.println("Tasks have not started");

            }
            else if (AvailableTask() == 0 && CompletedTask() > 0){
                    System.out.println("All tasks completed");
            }
            else {
                System.out.println("Number of outstanding tasks: " + AvailableTask() +
                        " Number of completed tasks " + CompletedTask());
            }
        }


        public void UpdateProgress (Scanner sc, Customer customer){ //utility method that is used multiple times in the app.java main method
                System.out.println("Enter the event ID for the task to be removed ");
                int selectedEventID = sc.nextInt();
                sc.nextLine();
               for(EventID eventID : customer.getEvents()) {
                   if (selectedEventID == eventID.getEventID()) {
                       System.out.println("Enter task to remove");
                       String removeTask = sc.nextLine();
                       taskRemover(selectedEventID, removeTask, customer); //uses the task remover method to update progress
                   } else {
                       System.out.println("Incorrect id");
                   }
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



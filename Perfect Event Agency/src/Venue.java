import java.util.Random;
import java.util.ArrayList;

public class Venue {
    private int venueID;
    private String name;
    private int capacity;
    private double price;
    private boolean availability;
    private ArrayList<String> availableDatesForInspection = new ArrayList<String>();
    private ArrayList<String> availableTimesForInspection = new ArrayList<String>();


    public Venue(String name, int capacity, double price, boolean availability, int venueID) {
        this.venueID = venueID;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.availability = availability;

        this.availableDatesForInspection.add("24/10/2022");
        this.availableDatesForInspection.add("28/10/2022");
        this.availableDatesForInspection.add("05/11/2022");
        this.availableDatesForInspection.add("10/11/2022");
        this.availableDatesForInspection.add("17/11/2022");

        this.availableTimesForInspection.add("10:00");
        this.availableTimesForInspection.add("13:00");
        this.availableTimesForInspection.add("15:00");
        this.availableTimesForInspection.add("17:00");

    }

    public Venue() {

    }

    //getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getVenueID() {
        return venueID;
    }

    public void setVenueID(int venueID) {
        this.venueID = venueID;
    }

    public ArrayList<String> getAvailableDatesForInspection() {
        return availableDatesForInspection;
    }

    public void setAvailableDatesForInspection(ArrayList<String> availableDatesForInspection) {
        this.availableDatesForInspection = availableDatesForInspection;
    }

    public ArrayList<String> getAvailableTimesForInspection() {
        return availableTimesForInspection;
    }

    public void setAvailableTimesForInspection(ArrayList<String> availableTimesForInspection) {
        this.availableTimesForInspection = availableTimesForInspection;
    }

    public void showInspectionDateandTime() {
        System.out.println("Available Dates for Inspection: ");
        for (int i = 0; i < availableDatesForInspection.size(); i++) {
            System.out.println(i);
            System.out.println(availableDatesForInspection.get(i));
        }
        System.out.println("Available Times for Inspection: ");
        for (int i = 0; i < availableTimesForInspection.size(); i++) {
            System.out.println(i);
            System.out.println(availableTimesForInspection.get(i));
        }
    }


    public void str() {
        System.out.println("Venue ID: " + getVenueID());
        System.out.println("Venue Name: " + getName());
        System.out.println("Venue Capacity: " + getCapacity());
        System.out.println("Venue Price: " + getPrice());
        System.out.println("Venue Availability: " + isAvailability());
    }
}

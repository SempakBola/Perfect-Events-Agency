import java.util.Random;

public class Venue {
    private String name;
    private int capacity;
    private double price;
    private boolean availability;

    public Venue(String name, int capacity, double price, boolean availability) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.availability = availability;
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


    public void str() {
        System.out.println("Venue Name: " + name);
        System.out.println("Venue Capacity: " + capacity);
        System.out.println("Venue Price: " + price);
        System.out.println("Venue Availability: " + availability);
    }
}

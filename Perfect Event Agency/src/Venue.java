import java.util.ArrayList;

public class Venue {
    private String name;
    private int capacity;
    private float price;
    private boolean availability;

    public Venue(String name, int capacity, float price, boolean availability) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

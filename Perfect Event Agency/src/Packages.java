import java.util.ArrayList;
import java.util.Random;
public class Packages {
    private String details;
    private double price;
    private int package_num;

    public Packages(int package_num, String details, double price) {
        this.details = details;
        this.price = price;
        this.package_num = package_num;
    }

    public void showAvailableVenues(ArrayList<Venue> venues, int package_num) {
        for (Venue venue : venues) {
            if (venue.getCapacity() >= package_num && venue.isAvailability()==true) {
                venue.str();
            }
        }
    }
        

    //getter and setter methods
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPackage_num() {
        return package_num;
    }

    public void setPackage_num(int package_num) {
        this.package_num = package_num;
    }

    public void str() {
        System.out.println("Package Details: " + details);
        System.out.println("Package Price: " + price);
        System.out.println("Package Number: " + package_num);
    }


    
}

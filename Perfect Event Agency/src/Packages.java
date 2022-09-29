import java.util.Random;
public class Packages {
    private String details;
    private double price;

    public Packages(String details, double price) {
        this.details = details;
        this.price = price;
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

    public void str() {
        System.out.println("Package Details: " + details);
        System.out.println("Package Price: " + price);
    }
    
}

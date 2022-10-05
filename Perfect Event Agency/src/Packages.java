import java.util.ArrayList;
public class Packages {
    private String details;
    private int package_num;
    private int capacity;

    public Packages(int package_num, String details, int capacity) {
        this.details = details;
        this.package_num = package_num;
        this.capacity = capacity;
    }

        

    //getter and setter methods
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public int getPackage_num() {
        return package_num;
    }

    public void setPackage_num(int package_num) {
        this.package_num = package_num;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void str() {
        System.out.println("Package Number: " + package_num);
        System.out.println("Package Details: " + details);
        System.out.println("Package Capacity: " + capacity);

    }


    
}

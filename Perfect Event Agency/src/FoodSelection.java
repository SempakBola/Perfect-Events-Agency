import java.util.Random;

public class FoodSelection {
    private int foodID;
    private String foodandBeveragePackage;
    private double price;

    public FoodSelection(String foodandBeveragePackage, double price, int foodID) {
        this.foodandBeveragePackage = foodandBeveragePackage;
        this.price = price;
        this.foodID = foodID;
    }

    public FoodSelection() {

    }

    public String getFoodandBeveragePackage() {
        return foodandBeveragePackage;
    }

    public void setFoodandBeveragePackage(String foodandBeveragePackage) {
        this.foodandBeveragePackage = foodandBeveragePackage;
    }

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public void str() {
        System.out.println("FoodID: " + getFoodID());
        System.out.println("Food and Beverage Package: " + getFoodandBeveragePackage());
        System.out.println("Price: " + getPrice());
    }

    
}


    


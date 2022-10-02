import java.util.Random;

public class FoodSelection {
    private String foodandBeveragePackage;
    private double price;

    public FoodSelection(String foodandBeveragePackage, double price) {
        this.foodandBeveragePackage = foodandBeveragePackage;
        this.price = price;
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

    public void str() {
        System.out.println("Food and Beverage Package: " + foodandBeveragePackage);
        System.out.println("Price: " + price);
    }

    
}


    


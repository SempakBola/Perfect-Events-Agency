import java.util.Random;

public class FoodSelection {
    private String foodandBeveragePackage;
    private float price;

    public FoodSelection(String foodandBeveragePackage, float price) {
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

    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }

    public void str() {
        System.out.println("Food and Beverage Package: " + foodandBeveragePackage);
        System.out.println("Price: " + price);
    }

    
}


    


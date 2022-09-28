import java.util.Dictionary;
import java.util.Hashtable;

public class FoodSelection {
    private Dictionary foodAndDrinks;

    public FoodSelection() {
        this.foodAndDrinks = new Hashtable();
    }

    //setter
    public void setFoodAndDrinks(Dictionary foodAndDrinks) {
        this.foodAndDrinks = foodAndDrinks;
    }

    //getter
    public Dictionary getFoodAndDrinks() {
        return foodAndDrinks;
    }

    //get element price
    public float getPrice(String foodSelection) {
        return (float) foodAndDrinks.get(foodSelection);
    }
}

//testing purposes
public static void main(String[]args) {
    FoodSelection foodSelection = new FoodSelection();
    foodSelection.getFoodAndDrinks().put("Chicken", 100.0f);
    System.out.print;

}


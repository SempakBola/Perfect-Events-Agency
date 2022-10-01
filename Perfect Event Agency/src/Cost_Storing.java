import java.util.List;

public class Cost_Storing {
    private Object item;
    private double cost;

    public Cost_Storing(Object item, double cost) {
        this.item = item;
        this.cost = cost;
    }

    public Cost_Storing() {

    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Cost_Storing{" +
                "item='" + item + '\'' +
                ", cost=" + cost + '\'' +
                '}';
    }
}

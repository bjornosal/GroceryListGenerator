import java.util.ArrayList;

public abstract class Meal {

    private String mealName;
    private ArrayList<Item> mealIngredients;

    public Meal(String mealName, ArrayList<Item> mealIngredients) {
        this.mealIngredients = mealIngredients;
        this.mealName = mealName;
    }

    public Meal() {
    }

    protected boolean addItemToMealIngredient(Item item) {
        return mealIngredients.add(item);
    }

    protected double getTotalPriceOfMeal() {
        return mealIngredients.stream()
                .mapToDouble(Item::getItemPrice)
                .sum();
    }

    public ArrayList<Item> getMealIngredients() {
        return mealIngredients;
    }

    public void setMealIngredients(ArrayList<Item> mealIngredients) {
        this.mealIngredients = mealIngredients;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealIngredients=" + mealIngredients +
                ", mealName='" + mealName + '\'' +
                '}';
    }
}

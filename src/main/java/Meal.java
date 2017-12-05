import java.util.ArrayList;

public abstract class Meal {

    private ArrayList<Item> mealIngredients;
    private String mealName;

    public Meal(ArrayList<Item> mealIngredients, String mealName) {
        this.mealIngredients = mealIngredients;
        this.mealName = mealName;
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
}

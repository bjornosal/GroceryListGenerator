import java.util.ArrayList;

public abstract class Meal {

    private ArrayList<Item> mealIngredients;

    public Meal(ArrayList<Item> mealIngredients) {
        this.mealIngredients = mealIngredients;
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
}

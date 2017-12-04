import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DinnerTest {
    Dinner dinner;

    @org.junit.Before
    public void setUp() throws Exception {
        ArrayList<Item> mealIngredients = new ArrayList<>();
        dinner = new Dinner(mealIngredients);
    }

    @Test
    public void testAddOneIngredientToIngredientsList() {
        Item potato = new Item("potato", 10, ItemCategory.FRUIT, 1);
        dinner.addItemToMealIngredient(potato);
        dinner.getTotalPriceOfMeal();
        assertThat(dinner.getMealIngredients().size(), is(1));
    }

}
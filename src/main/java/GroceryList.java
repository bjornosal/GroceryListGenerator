import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroceryList {

    private ArrayList<Item> groceryList;

    public GroceryList() {
        groceryList = new ArrayList<>();
    }

    protected boolean addItemToGroceryList(Item item) {
        return groceryList.add(item);
    }

    protected double getTotalPriceOfGroceryList() {
        return groceryList.stream()
                .mapToDouble(Item::getItemPrice)
                .sum();
    }

    protected String getAllItemsInGroceryList() {
        return groceryList.stream()
                .map(Item::getItemName)
                .collect(Collectors.joining("\n"));

    }
}

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONHandler {
    //TODO parse json file and create meals/dinners from the objects
    //TODO create items from the arrays in the objects? If it does not exist, add it to the json file.
    //parse information from file, generate dinners from the info
    //use that information to fill a list and return a list of all dinners.

    public ArrayList<Dinner> parseDinnersFile() {
        JSONObject jsonObject = new JSONObject("files/dinners.json");
        ArrayList<Dinner> dinnersInFile = new ArrayList<>();

//TODO Use Gson instead??
        JSONArray jsonDinners = new JSONArray("files/dinners.json");
        for (int i = 0; i < jsonDinners.length(); i++) {
            ArrayList<Item> ingredients = new ArrayList<>();
            String dinnerName = jsonDinners.getJSONObject(i).getString("name");
            JSONArray dinnerIngredients = new JSONArray("ingredients");

            for(int j = 0; j < dinnerIngredients.length(); j++) {
                String itemName = dinnerIngredients.getJSONObject(j).getString("itemName");
                Double itemPrice = dinnerIngredients.getJSONObject(j).getDouble("itemPrice");
                String itemCategoryFromJson = dinnerIngredients.getJSONObject(j).getString("itemCategory");
                int itemQuantity = dinnerIngredients.getJSONObject(j).getInt("itemQuantity");

                ItemCategory itemCategory = ItemCategory.valueOf(itemCategoryFromJson);
                ingredients.add(new Item(itemName, itemPrice, itemCategory, itemQuantity));
            }

            dinnersInFile.add(new Dinner(ingredients, dinnerName));
        }

        return dinnersInFile;
    }
}

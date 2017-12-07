
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;

public class JSONHandler {

    public ArrayList<Dinner> getDinnersFromFile() throws FileNotFoundException {

        JSONArray jsonDinners = new JSONArray(new JSONTokener(new FileInputStream(new File("files/dinners.json"))));

        return parseDinnerArray(jsonDinners);
    }

    private ArrayList<Dinner> parseDinnerArray(JSONArray jsonArray) {
        ArrayList<Dinner> list = new ArrayList<>();

        for (Object item : jsonArray) {
            JSONObject object = (JSONObject) item;
            Dinner dinner = new Dinner();
            dinner.setMealName(object.getString("name"));
            dinner.setMealIngredients(parseMealIngredients((JSONArray) object.get("ingredients")));
            list.add(dinner);
        }
        return list;
    }

    private ArrayList<Item> parseMealIngredients(JSONArray array) {

        ArrayList<Item> list = new ArrayList<>();

        for (Object item : array) {
            JSONObject object = (JSONObject) item;
            Item ingredient = new Item();
            ingredient.setItemName(object.getString("itemName"));
            ingredient.setItemPrice(object.getDouble("itemPrice"));
            ingredient.setQuantity(object.getInt("itemQuantity"));
            ingredient.setItemCategory(object.getString("itemCategory"));
            list.add(ingredient);
        }
        return list;
    }

}


import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JSONHandler {
    //TODO parse json file and create meals/dinners from the objects
    //TODO create items from the arrays in the objects? If it does not exist, add it to the json file.
    //parse information from file, generate dinners from the info
    //use that information to fill a list and return a list of all dinners.


    public ArrayList<Dinner> parseDinnersFile() throws FileNotFoundException {

        //TODO Use Gson instead??
        JSONArray jsonDinners = new JSONArray(new JSONTokener(new FileInputStream(new File("files/dinners.json"))));

        ArrayList<Dinner> dinners = parseDinnerArray(jsonDinners);

        System.out.println(dinners);
        return dinners;
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

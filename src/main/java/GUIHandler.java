import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GUIHandler extends Application {

    private TextField itemField;
    private ListView<Item> itemList;
    private ListView<String> dinnerList;

    private ArrayList<Dinner> dinners;

    public void setUpGUI() {
        launch();
    }

    @Override
    public void start(Stage mainWindow) throws Exception {
        mainWindow.setTitle("Grocery list Generator");

        BorderPane windowLayout = new BorderPane();
        VBox windowRight = new VBox();
        VBox windowCenter = new VBox();

        addGroceryListToLayout(windowCenter);
        addDinnerListToLayout(windowCenter);
        windowLayout.setCenter(windowCenter);

        addItemFieldAndButtonsToLayout(windowRight);
        addGenerateDinnersButtonToLayout(windowRight);
        addAddIngredientsFromDinnersButtonToLayout(windowRight);
        windowLayout.setRight(windowRight);

        Scene scene = new Scene(windowLayout, 500, 750);

        mainWindow.setScene(scene);
        mainWindow.show();
    }


    private void addGroceryListToLayout(VBox layout) {
        Label listLabel = new Label("Grocery list");

        listLabel.setAlignment(Pos.CENTER);
        itemList = new ListView<>();

        layout.getChildren().add(listLabel);
        layout.getChildren().add(itemList);

        itemList.setMinHeight(100);
        itemList.setMaxHeight(500);
        itemList.setMinWidth(150);
        itemList.setMaxWidth(500);
        itemList.setPrefHeight(400);

        listLabel.setMinWidth(itemList.getMinWidth());
        listLabel.setMaxWidth(itemList.getMaxWidth());
    }

    private void addDinnerListToLayout(VBox layout) {
        Label dinnerLabel = new Label("Dinners");
        dinnerList = new ListView<>();

        layout.getChildren().add(dinnerLabel);
        layout.getChildren().add(dinnerList);

        dinnerList.setMinHeight(100);
        dinnerList.setMaxHeight(165);
        dinnerList.setMinWidth(150);
        dinnerList.setMaxWidth(500);
        dinnerList.setPrefHeight(165);

        dinnerLabel.setAlignment(Pos.CENTER);
        dinnerLabel.setMinWidth(dinnerList.getMinWidth());
        dinnerLabel.setMaxWidth(dinnerList.getMaxWidth());
    }


    private void addItemFieldAndButtonsToLayout(VBox layout) {
        Button addButton = new Button("Add item");
        Button deleteButton = new Button("Remove item");
        itemField = new TextField("Item:");

        addButton.setOnAction(event -> addItemToList());
        deleteButton.setOnAction(event -> removeItemFromList());

        layout.getChildren().add(itemField);
        layout.getChildren().add(addButton);
        layout.getChildren().add(deleteButton);
    }

    private void addGenerateDinnersButtonToLayout(VBox layout) {
        Button generateButton = new Button("Generate dinners");

        generateButton.setOnAction(event -> {
            try {
                dinnerList.getItems().clear();
                addDinnersToDinnerView();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        layout.getChildren().add(generateButton);
    }

    private void addAddIngredientsFromDinnersButtonToLayout(VBox layout) {
        Button ingredientsButton = new Button("Add all ingredients");
        ingredientsButton.setOnAction(event -> addDinnerIngredientsToItemList());
        layout.getChildren().add(ingredientsButton);
    }

    //TODO Add updateQuantity method?

    //TODO If it does not exist in json, ask for item category and estimated price
    //TODO if exists in list, update quantity. How?
    private boolean addItemToList() {
        Item itemFromField = new Item(itemField.getText(), 0, "ItemCategory.FRUIT", 1);
        return itemList.getItems().add(itemFromField);
    }

    private boolean addItemToList(Item item) {
        return itemList.getItems().add(item);
    }

    private boolean removeItemFromList() {
        int selectedIndex = itemList.getSelectionModel().getSelectedIndex();
        if(selectedIndex != -1) {
            itemList.getItems().remove(selectedIndex);
        }
        return false;
    }

    private ArrayList<Dinner> generateDinners() throws FileNotFoundException {
        JSONHandler jsonHandler = new JSONHandler();
        ArrayList<Dinner> possibleDinners = jsonHandler.getDinnersFromFile();

        ArrayList<Dinner> dinners = new ArrayList<>();
        Collections.shuffle(possibleDinners);

        for(int i = 0; i < 7; i++) {
            dinners.add(possibleDinners.get(i));
        }

        return dinners;
    }

    private void addDinnersToDinnerView() throws FileNotFoundException {
        dinners = generateDinners();
        dinners.forEach(this::addDinnerToDinnerView);
    }

    private void addDinnerToDinnerView(Dinner dinner){
        dinnerList.getItems().add(dinner.getMealName());
    }

    private List<ArrayList<Item>> getIngredientsFromDinners() {
        return dinners.stream()
                .map(Meal::getMealIngredients)
                .collect(Collectors.toList());
    }

    private void addDinnerIngredientsToItemList(){
        getIngredientsFromDinners()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList())
                .forEach(this::addItemToList);
    }
}
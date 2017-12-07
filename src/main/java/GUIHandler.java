import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.invoke.VolatileCallSite;

public class GUIHandler extends Application {

    private TextField itemField;
    private ListView<Item> itemList;
    private ListView<Item> dinnerList;


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
        addItemFieldAndButtonsToLayout(windowRight);

        windowLayout.setRight(windowRight);
        windowLayout.setCenter(windowCenter);

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
        dinnerList.setMaxHeight(400);
        dinnerList.setMinWidth(150);
        dinnerList.setMaxWidth(500);
        dinnerList.setPrefHeight(300);

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

    //TODO If it does not exist in json, ask for item category and estimated price
    //TODO if exists in list, update quantity. How?
    private boolean addItemToList() {
        Item itemFromField = new Item(itemField.getText(), 0, "ItemCategory.FRUIT", 1);
        return itemList.getItems().add(itemFromField);
    }

    private boolean removeItemFromList() {
        int selectedIndex = itemList.getSelectionModel().getSelectedIndex();
        if(selectedIndex != -1) {
            itemList.getItems().remove(selectedIndex);
        }
        return false;
    }

    //TODO needs to get random dinners from json file
    private void generateDinners() {

    }

    //TODO Add scene for dinners/Just add a new listview and label?
    //TODO Add functionality for choosing item category
    //TODO Format window properly


}

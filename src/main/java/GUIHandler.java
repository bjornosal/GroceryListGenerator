import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUIHandler<T> extends Application {

    private Label listLabel;
    private TextField itemField;
    private ListView<Item> itemList;

    public void setUpGUI() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("Grocery list Generator");

        BorderPane windowLayout = new BorderPane();
        VBox windowLeft = new VBox();
        VBox windowCenter = new VBox();

        addGroceryListToLayout(windowCenter);
        addItemFieldAndButtonToLayout(windowLeft);

        windowLayout.setRight(windowLeft);
        windowLayout.setCenter(windowCenter);

        Scene scene = new Scene(windowLayout, 500, 350);

        window.setScene(scene);
        window.show();
    }

    private void addGroceryListToLayout(VBox layout) {
        listLabel = new Label("Grocery list");
        itemList = new ListView<>();

        layout.getChildren().addAll(listLabel);
        layout.getChildren().add(itemList);

        itemList.setMinHeight(100);
        itemList.setMaxHeight(800);
        itemList.setMinWidth(150);
        itemList.setMaxWidth(500);
        itemList.setPrefHeight(500);
    }

    private void addItemFieldAndButtonToLayout(VBox layout) {
        Button button = new Button("Add item");
        itemField = new TextField("What item to add?");

        button.setOnAction(event -> addItemToList());
        layout.getChildren().add(itemField);
        layout.getChildren().add(button);
    }

    /*TODO
    If it does not exist in json,
    ask for item category and estimated price
     */
    private void addItemToList() {
        Item itemFromField = new Item(itemField.getText(), 0, ItemCategory.FRUIT);
        itemList.getItems().add(itemFromField);
    }

    //TODO Add remove button
    //TODO Add scene for dinners
    //TODO Add functionality for choosing item category
    //TODO Format window properly


}

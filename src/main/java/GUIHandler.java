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
    private TextField itemName;

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
        ListView<Item> itemList = new ListView<>();
        layout.getChildren().addAll(listLabel);
        layout.getChildren().add(itemList);

        itemList.setMinHeight(100);
        itemList.setMaxHeight(800);
        itemList.setMinWidth(150);
        itemList.setMaxWidth(500);
        itemList.setPrefHeight(70);
    }

    private void addItemFieldAndButtonToLayout(VBox layout) {
        Button button = new Button("Add item");
        itemName = new TextField("What item to add?");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        layout.getChildren().add(button);
    }

    // Add an item to the list. If it does not already exist in the json file
    // then ask for more information
    private void addItemToList(Item item) {

    }

}

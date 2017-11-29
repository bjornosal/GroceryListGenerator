import java.util.Scanner;

public class InputHandler {

    private GroceryList groceryList;
    private Scanner scanner;

    public InputHandler() {
        groceryList = new GroceryList();
        scanner = new Scanner(System.in);
    }

    /**
     * Returns a string for the terminal menu
     * @return startmenu string
     */
    public String startMenu() {
        return "What do you want to do?\n" +
                "1: Generate dinners.\n" +
                "2: Add item to list.\n" +
                "3: Print grocery list.\n" +
                "4: Save grocery list to file.\n" +
                "5: Quit";
    }

    public void startMenuChoice(String input) {
        switch(input) {
            case "1":

                break;
            case "2":
                System.out.println("What is the name of the item?");
                addItemToGroceryList(scanner.nextLine());
                System.out.println(groceryList.getAllItemsInGroceryList());
                break;

        }
    }

    public String getUserFeedInput() {
        return scanner.nextLine();
    }

    public boolean addItemToGroceryList(String itemName) {
        //placeholder values
        double itemPrice = 20;
        ItemCategory itemCategory = ItemCategory.FRUIT;

        Item item = new Item(itemName, itemPrice, itemCategory);
        return groceryList.addItemToGroceryList(item);
    }







}

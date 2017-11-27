/**
 * For testing items and adding to list first off
 */

public class DairyProduct extends Item{
    private String itemName;
    private double itemPrice;
    private ItemCategory itemCategory;

    public DairyProduct(String itemName, double itemPrice, ItemCategory itemCategory) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
    }
}

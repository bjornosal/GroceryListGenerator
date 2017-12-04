public class Item {

    private String itemName;
    private double itemPrice;
    private ItemCategory itemCategory;
    private int quantity;

    public Item(String itemName, double itemPrice, ItemCategory itemCategory, int quantity) {
        setItemName(itemName);
        setItemPrice(itemPrice);
        setItemCategory(itemCategory);
        setQuantity(quantity);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getItemName() + " - Amount: "+getQuantity();
    }
}

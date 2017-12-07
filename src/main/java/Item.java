public class Item {

    private String itemName;
    private double itemPrice;
    private String itemCategory;
    private int quantity;

    public Item(String itemName, double itemPrice, String itemCategory, int quantity) {
        setItemName(itemName);
        setItemPrice(itemPrice);
        setItemCategory(itemCategory);
        setQuantity(quantity);
    }

    public Item() {
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

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
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

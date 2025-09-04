package lab7;

class ShoppingBasketItem {
    private String productName;
    private int quantity;
    private double price;
    
    public ShoppingBasketItem(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Item: " + productName + ", Quantity: " + quantity + ", Price: £" + price;
    }
}
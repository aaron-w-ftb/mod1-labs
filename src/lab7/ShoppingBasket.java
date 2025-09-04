package lab7;

import java.util.*;

class ShoppingBasket {
    private ArrayList<ShoppingBasketItem> items;
    
    public ShoppingBasket() {
        items = new ArrayList<ShoppingBasketItem>();
    }
    
    public void add(ShoppingBasketItem item) {
        items.add(item);
    }
    
    public ArrayList<ShoppingBasketItem> getItems() {
        return items;
    }
    
    @Override
    public String toString() {
        return "Shopping Basket with " + items.size() + " items";
    }
}
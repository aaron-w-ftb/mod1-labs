package lab7;

import java.util.*;

class Program {
    private static Queue<ShoppingBasket> baskets = new LinkedList<ShoppingBasket>();
    
    public static void main(String[] args) {
        System.out.println("ArrayList<Shape>");
        Game game = new Game();
        game.addShape(new Shape("Circle"));
        game.addShape(new Shape("Square"));
        game.addShape(new Shape("Triangle"));
        game.displayShapes();
        
        System.out.println("\nQueue");
        
        ShoppingBasket basket1 = new ShoppingBasket();
        basket1.add(new ShoppingBasketItem("Apple", 5, 1.99));
        basket1.add(new ShoppingBasketItem("Bread", 2, 2.49));
        
        ShoppingBasket basket2 = new ShoppingBasket();
        basket2.add(new ShoppingBasketItem("Milk", 1, 3.29));
        basket2.add(new ShoppingBasketItem("Eggs", 1, 2.99));
        
        baskets.add(basket1);
        baskets.add(basket2);
        
        processBaskets();
        
        System.out.println("\nHashMap");
        Zoo zoo = new Zoo();
        zoo.displayAnimalData();
    }
    
    public static void processBaskets() {
        System.out.println("Processing shopping baskets.");
        
        while (!baskets.isEmpty()) {
            ShoppingBasket currentBasket = baskets.poll();
            System.out.println("Processing: " + currentBasket);
            
            for (ShoppingBasketItem item : currentBasket.getItems()) {
                System.out.println("  " + item);
            }
            System.out.println("Basket processed.\n");
        }
        
        System.out.println("All baskets have been processed.");
    }
}
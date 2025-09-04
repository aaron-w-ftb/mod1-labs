package lab7;

import java.util.*;

class Game {
    private ArrayList<Shape> shapes;
    
    public Game() {
        shapes = new ArrayList<Shape>();
    }
    
    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    
    public void displayShapes() {
        for (Shape shape : shapes) {
            System.out.println("Shape: " + shape.getName());
        }
    }
    
    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}
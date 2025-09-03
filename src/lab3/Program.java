package lab3;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
    	
        // Testing the lunch queue method
        System.out.println("Lunch Queue");
        theLunchQueue();
        
        System.out.println("\nWeight Conversions");
        // Converting pounds to stones and pounds
        int weightInPounds = getInt("Enter your weight in pounds: ");
        convertInputToStonesPounds(weightInPounds);
        
        // Converting kilogrammes to stones and pounds
        int weightInKg = getInt("Enter your weight in kg: ");
        convertKgsToStonesPounds(weightInKg);
        
        System.out.println("\nUsing Utils Class");
        // Using the separate Utils class
        Utils utils = new Utils();
        int potatoes = utils.getInt("How many roast potatoes would you like? ");
        System.out.println("You chose " + potatoes + " potatoes using the Utils class!");
    }
    
    // Helper method to get integer input
    public static int getInt(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        return s.nextInt();
    }
    
    // Helper method to get string input
    public static String getString(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        return s.nextLine();
    }
    
    // Lunch queue method
    public static void theLunchQueue() {
        String mainCourse = getString("What main dish would you like (fish, burgers or veg)? ");
        int potatoes = getInt("How many roast potatoes would you like? ");
        int sprouts = getInt("How many Brussels Sprouts would you like? ");
        
        System.out.println("Hello, your lunch is " + mainCourse + " with " + 
                         potatoes + " roast potatoes and " + sprouts + " Brussels sprouts.");
    }
    
    // Convert pounds to stones and pounds
    public static void convertInputToStonesPounds(int pounds) {
        int stones = pounds / 14;
        int remainingPounds = pounds % 14;
        System.out.println(pounds + " pounds = " + stones + " stones and " + 
                         remainingPounds + " pounds");
    }
    
    // Converting kilogrammes to stones and pounds
    public static void convertKgsToStonesPounds(int kg) {
        double pounds = kg * 2.20462;
        int totalPounds = (int) pounds;
        System.out.println(kg + " kg = " + pounds + " pounds");
        convertInputToStonesPounds(totalPounds);
    }
}
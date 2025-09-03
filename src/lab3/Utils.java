package lab3;
import java.util.Scanner;

public class Utils {
    // Non-static methods (removed static keyword)
    public int getInt(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        return s.nextInt();
    }
    
    public String getString(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.print(prompt);
        return s.nextLine();
    }
}
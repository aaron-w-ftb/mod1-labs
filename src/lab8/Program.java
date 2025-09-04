package lab8;

import java.io.*;

public class Program {
    
    public static void main(String[] args) {
        Account account = new Account(123, 100.0, "John Doe");
        
        try {
            System.out.println("Initial account details:");
            System.out.println(account.getDetails());
            
            account.withdraw(50.0);
            System.out.println("After withdrawing £50:");
            System.out.println(account.getDetails());
            
            System.out.println("\nAttempting to withdraw £60...");
            account.withdraw(60.0);
            System.out.println(account.getDetails());
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            account.close();
        }
        
        try {
            log("This is a test log message");
            System.out.println("Log message written successfully");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
    
    private static void log(String msg) throws IOException {
        File file = new File("log.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(msg + "\n");
        br.close();
        fr.close();
    }
}
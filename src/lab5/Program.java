package lab5;

public class Program {
    
    public static void main(String[] args) {
        System.out.println("Getting Started\n");

        System.out.println("Creating and using reference types");

        Account myAccount = new Account(1, "John Doe", 1000.0);
        
        System.out.println("Initial account state:");
        System.out.println(myAccount.getDetails());
        System.out.println();
        
        myAccount.deposit(250.0);
        myAccount.withdraw(100.0);
        myAccount.deposit(-50.0);
        myAccount.withdraw(2000.0);
        System.out.println("\nFinal account state after transactions:");
        System.out.println(myAccount.getDetails());
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        System.out.println("Creating an array of reference types");
        Account[] accountArray = new Account[3];

        accountArray[0] = new Account(101, "Alice Smith", 1500.0);
        accountArray[1] = new Account(102, "Bob Johnson", 2000.0);
        accountArray[2] = new Account(103, "Carol Williams", 750.0);
        System.out.println("Account details from array:");
        for (Account account : accountArray) {
            System.out.println(account.getDetails());
            System.out.println();
        
        System.out.println("=".repeat(50) + "\n");

        System.out.println("Passing reference types to a method");

        Account myTestAccount = new Account(201, "Test User", 1000.0);
        System.out.println("Before adding interest:");
        System.out.println(myTestAccount.getDetails());
        System.out.println();

        myTestAccount.addInterest();
        
        System.out.println("\nAfter adding interest:");
        System.out.println(myTestAccount.getDetails());
        System.out.println("\nDid the balance change? Yes -- because objects are passed by reference.");
        System.out.println();

        Account partnerAccount = myTestAccount;
        
        System.out.println("Created partnerAccount = myTestAccount");
        System.out.println("partnerAccount balance before addInterest(): £" + partnerAccount.getBalance());
        
        partnerAccount.addInterest();
        
        System.out.println("myTestAccount balance after partnerAccount.addInterest(): £" + myTestAccount.getBalance());
        System.out.println("Did the balance change? Yes -- both variables reference the same object.");
        System.out.println();

        System.out.println("Testing static processAccount method:");
        System.out.println("myTestAccount balance before processAccount(): £" + myTestAccount.getBalance());
        
        processAccount(myTestAccount);
        
        System.out.println("myTestAccount balance after processAccount(): £" + myTestAccount.getBalance());
        System.out.println("Did the balance change? Yes -- reference types are modified directly.");
        System.out.println();
        
        System.out.println("Demonstrating primitive vs reference type behavior:");
        int k = 100;
        System.out.println("Value of k before incInt(): " + k);
        
        incInt(k);
        
        System.out.println("Value of k after incInt(): " + k);
        System.out.println("Did k change after the call? No - primitives are passed by value.");
        System.out.println();
        
        System.out.println("=".repeat(50));
        System.out.println("A summary of key concepts demonstrated;");
        System.out.println("1. Reference types store addresses to objects in memory.");
        System.out.println("2. When you pass reference types to methods, you pass the address.");
        System.out.println("3. Changes made inside methods affect the original object.");
        System.out.println("4. Primitive types are always passed by value (copy of the value).");
        System.out.println("5. Multiple variables can reference the same object.");
        }
    }
    
    public static void processAccount(Account acc) {
        System.out.println("Inside processAccount method:");
        System.out.println("Account balance before interest: £" + acc.getBalance());
        
        acc.addInterest();
        
        System.out.println("Account balance after interest: £" + acc.getBalance());
    }
    private static void incInt(int x) {
        System.out.println("Inside incInt method, x = " + x);
    }
}
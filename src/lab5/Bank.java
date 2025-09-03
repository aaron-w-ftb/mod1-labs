package lab5;

public class Bank {
    private Account[] accounts;
    private int accountCount;
    private static final int MAX_ACCOUNTS = 3;

    public Bank() {
        this.accounts = new Account[MAX_ACCOUNTS];
        this.accountCount = 0;
        System.out.println("Bank created with capacity for " + MAX_ACCOUNTS + " accounts.");
    }
    
    public Account addAccount(String owner, double balance) {
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("Error: Bank storage is full.(4) Cannot add more than " + MAX_ACCOUNTS + " accounts.");
            return null;
        }

        int newId = accountCount + 1;
        Account newAccount = new Account(newId, owner, balance);

        accounts[accountCount] = newAccount;
        accountCount++;
        
        System.out.println("Successfully added account for " + owner + " with ID: " + newId);
        return newAccount;
    }
    
    public Account getAccount(String owner) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getOwner().equals(owner)) {
                System.out.println("Found account for " + owner);
                return accounts[i];
            }
        }

        System.out.println("No account found for owner: " + owner);
        return null;
    }

    public void displayAllAccounts() {
        System.out.println("\nAll Bank Accounts");
        if (accountCount == 0) {
            System.out.println("No accounts in the bank.");
            return;
        }
        
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null) {
                System.out.println("Account " + (i + 1) + ":");
                System.out.println(accounts[i].getDetails());
                System.out.println();
            }
        }
    }
    
    public int getAccountCount() {
        return accountCount;
    }
    
    public boolean isFull() {
        return accountCount >= MAX_ACCOUNTS;
    }

    public static void testBankClass() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TESTING BANK CLASS FUNCTIONALITY");
        System.out.println("=".repeat(50));

        Bank myBank = new Bank();

        System.out.println("\nAdding three accounts;");
        Account acc1 = myBank.addAccount("John Smith", 1000.0);
        Account acc2 = myBank.addAccount("Jane Doe", 1500.0);
        Account acc3 = myBank.addAccount("Bob Wilson", 2000.0);

        myBank.displayAllAccounts();

        System.out.println("Adding a fourth account;");
        Account acc4 = myBank.addAccount("Alice Brown", 500.0);
        
        if (acc4 == null) {
            System.out.println("Correctly returned null when storage is full.");
        }

        System.out.println("\nTest 3: Searching for existing customer;");
        Account foundAccount = myBank.getAccount("Jane Doe");
        if (foundAccount != null) {
            System.out.println("Successfully found account:");
            System.out.println(foundAccount.getDetails());
        }

        System.out.println("\nSearching for non-existing customer;");
        Account notFound = myBank.getAccount("Unknown Person");
        if (notFound == null) {
            System.out.println("Correctly returned null for unknown customer.");
        }
        
        System.out.println("\nBank testing completed.");
        System.out.println("Final account count: " + myBank.getAccountCount() + "/" + MAX_ACCOUNTS);
    }
}
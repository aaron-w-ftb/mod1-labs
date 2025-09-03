package lab5;

public class Account {
    private int id;
    private String owner;
    private double balance;
    public Account(int id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Error: Cannot deposit a negative amount of money.(1)");
            return;
        }
        this.balance += amount;
        System.out.println("Deposited $" + amount + ". New balance: $" + this.balance);
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Error: Cannot withdraw a negative amount.(2)");
            return;
        }

        if (amount > this.balance) {
            System.out.println("Error: Cannot withdraw money you don't have.(3) Current balance: $" + this.balance);
            return;
        }

        this.balance -= amount;
        System.out.println("Withdrew $" + amount + ". New balance: $" + this.balance);
    }

    public String getDetails() {
        return String.format("Account Details:\n" +
                           "ID: %d\n" +
                           "Owner: %s\n" +
                           "Balance: $%.2f", 
                           this.id, this.owner, this.balance);
    }

    public void addInterest() {
        double interestRate = 0.025;
        double interestAmount = this.balance * interestRate;
        this.balance += interestAmount;
        System.out.println("Interest added: $" + String.format("%.2f", interestAmount) + 
                          ". New balance: $" + String.format("%.2f", this.balance));
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }
}
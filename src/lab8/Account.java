package lab8;

class Account {
    private int id;
    private double balance;
    private String owner;
    
    public Account(int id, double balance, String owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }
    
    public void withdraw(double amount) throws IllegalArgumentException {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds. Current balance: " + balance + ", Attempted withdrawal: " + amount);
        }
        balance -= amount;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void close() {
        System.out.println("Account " + id + " is closed");
    }
    
    public String getDetails() {
        return "ID: " + id + ", Balance: " + balance + ", Owner: " + owner;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public int getId() {
        return id;
    }
}
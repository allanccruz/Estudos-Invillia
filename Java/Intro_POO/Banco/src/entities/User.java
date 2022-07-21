package entities;

public class User {
    private String accountHolderName;
    private final int accountId;
    private double balance;

    public User(String accountHolderName, int accountId, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.accountId = accountId;
        deposit(initialDeposit);
    }

    public User(String accountHolderName, int accountId) {
        this.accountHolderName = accountHolderName;
        this.accountId = accountId;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        double tax = 5.00;
        this.balance -= amount + tax;
    }

    public String toString() {
        return "Account "
                + accountId
                + ", Holder: "
                + accountHolderName
                + ", Balance: $ "
                + String.format("%.2f", balance);
    }
}
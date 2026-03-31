public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = (initialBalance > 0) ? initialBalance : 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("123456", "John Doe", 1000.0);

        myAccount.displayAccountInfo();
        
        myAccount.deposit(500.0);
        System.out.println("Balance after deposit: " + myAccount.getBalance());

        myAccount.withdraw(200.0);
        System.out.println("Balance after withdrawal: " + myAccount.getBalance());

        myAccount.withdraw(2000.0);
        
        System.out.println("\nFinal State:");
        myAccount.displayAccountInfo();
    }
}

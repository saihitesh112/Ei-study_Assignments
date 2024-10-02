import java.util.Scanner;
interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

class RealBankAccount implements BankAccount {
    private double balance;
 
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
 
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }
 
    @Override
    public double getBalance() {
        return balance;
    }
}

class SecureBankAccountProxy implements BankAccount {
    private RealBankAccount realBankAccount;
    private String password;
 
    public SecureBankAccountProxy(String password) {
        this.password = password;
        authenticate();
    }
 
    private void authenticate() {
        if (password.equals("password")) {
            realBankAccount = new RealBankAccount();
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed. Access denied.");
        }
    }
 
    @Override
    public void deposit(double amount) {
        if (realBankAccount != null) {
            realBankAccount.deposit(amount);
        }
    }
 
    @Override
    public void withdraw(double amount) {
        if (realBankAccount != null) {
            realBankAccount.withdraw(amount);
        }
    }
 
    @Override
    public double getBalance() {
        return (realBankAccount != null) ? realBankAccount.getBalance() : 0.0;
    }
}


public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input the password
        System.out.print("Enter password to authenticate: ");
        String password = scanner.nextLine();

        BankAccount account = new SecureBankAccountProxy(password);

        // If the authentication fails, the program should terminate
        if (account.getBalance() == 0 && !(password.equals("password"))) {
            System.out.println("Exiting due to failed authentication.");
            scanner.close();
            return;
        }

        // Perform banking operations
        while (true) {
            System.out.println("\nChoose an operation: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

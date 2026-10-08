import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
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
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
            double penaltyPercent = calculatePenalty(amount - balance);
            double penalty = (balance * penaltyPercent) / 100;
            balance -= penalty;
            System.out.println("Penalty of " + penaltyPercent + "% applied: " + penalty);
        }
    }

    private double calculatePenalty(double deficit) {
        if (deficit <= 1000)
            return 10;
        else if (deficit <= 5000)
            return 20;
        else
            return 30;
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        BankAccount account = new BankAccount(accNo, name, balance);
        System.out.print("Enter deposit amount: ");
        double depositAmt = sc.nextDouble();
        account.deposit(depositAmt);
        System.out.print("Enter withdrawal amount: ");
        double withdrawAmt = sc.nextDouble();
        account.withdraw(withdrawAmt);
        account.displayAccount();

        sc.close();
    }
}

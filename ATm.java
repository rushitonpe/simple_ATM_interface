import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private double balance;
    private ArrayList<String> transactionHistory;

    public ATM() {
        balance = 0.0;
        transactionHistory = new ArrayList<>();
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        boolean quit = false;

        System.out.println("Welcome to the ATM.");

        while (!quit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction history");
            System.out.println("6. Quit");
    
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }  
        }
    }

    private void viewBalance() {
        System.out.printf("Current balance: ₹%.2f\n", balance);
    }

    private void withdraw() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter withdrawal amount: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;

        System.out.printf("Withdrawal of ₹%.2f successful.\n", amount);
        transactionHistory.add(String.format("Withdrawal of ₹%.2f", amount));
    }

    private void deposit() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter deposit amount: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        balance += amount;

        System.out.printf("Deposit of ₹%.2f successful.\n", amount);
        transactionHistory.add(String.format("Deposit of ₹%.2f", amount));
    }

    private void transfer() {
        Scanner input = new Scanner(System.in); 

        System.out.print("Enter transfer amount: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }
        
        System.out.print("Enter recipient's account number: ");
        int accountNumber = input.nextInt();

        System.out.printf("Transfer of ₹%.2f to account %d successful.\n", amount, accountNumber);
        transactionHistory.add(String.format("Transfer of ₹%.2f to account %d", amount, accountNumber));
    }

    private void viewTransactionHistory() {
        System.out.println("Transaction history:");

        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
  
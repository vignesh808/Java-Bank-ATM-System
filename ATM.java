package com.bank.atm;

import java.util.Scanner;

public class ATM {

    public void start(Account account) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome, " + account.getHolderName());
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Change PIN");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    System.out.println("SUCCESS: Amount deposited.");
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double wd = sc.nextDouble();
                    if (account.withdraw(wd)) {
                        System.out.println("SUCCESS: Please collect your cash.");
                    } else {
                        System.out.println("ERROR: Insufficient balance.");
                    }
                    break;

                case 4:
                    System.out.println("Transaction History:");
                    for (String t : account.getTransactions()) {
                        System.out.println(t);
                    }
                    break;

                case 5:
                    System.out.print("Enter old PIN: ");
                    int oldPin = sc.nextInt();
                    if (account.validatePin(oldPin)) {
                        System.out.print("Enter new PIN: ");
                        int newPin = sc.nextInt();
                        account.changePin(newPin);
                        System.out.println("SUCCESS: PIN updated.");
                    } else {
                        System.out.println("ERROR: Incorrect PIN.");
                    }
                    break;

                case 6:
                    System.out.println("Logged out successfully.");
                    break;

                default:
                    System.out.println("ERROR: Invalid choice.");
            }

        } while (choice != 6);
    }
}

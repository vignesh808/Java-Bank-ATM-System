package com.bank.atm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        ATM atm = new ATM();

        // Sample account
        bank.createAccount(101, "Vignesh", 1234, 5000);

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        Account account = bank.login(accNo, pin);

        if (account != null) {
            atm.start(account);
        } else {
            System.out.println("ERROR: Invalid account number or PIN.");
        }
    }
}

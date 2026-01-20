package com.bank.atm;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int accountNumber;
    private String holderName;
    private int pin;
    private double balance;
    private List<String> transactions;

    public Account(int accountNumber, String holderName, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: " + amount);
            return true;
        }
        return false;
    }

    public void changePin(int newPin) {
        this.pin = newPin;
        transactions.add("PIN changed");
    }

    public List<String> getTransactions() {
        return transactions;
    }
}

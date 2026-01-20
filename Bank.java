package com.bank.atm;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Integer, Account> accounts = new HashMap<>();

    public void createAccount(int accNo, String name, int pin, double balance) {
        if (accounts.containsKey(accNo)) {
            System.out.println("ERROR: Account already exists.");
        } else {
            accounts.put(accNo, new Account(accNo, name, pin, balance));
            System.out.println("SUCCESS: Account created.");
        }
    }

    public Account login(int accNo, int pin) {
        Account acc = accounts.get(accNo);
        if (acc != null && acc.validatePin(pin)) {
            return acc;
        }
        return null;
    }
}

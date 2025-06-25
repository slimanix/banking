package com.skypay.banking.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un compte bancaire avec un identifiant, un solde et une liste de transactions.
 */
public class Account {
    // Identifiant unique du compte
    private Long id;
    // Solde courant du compte
    private int balance;
    // Historique des transactions du compte
    private List<Transaction> transactions = new ArrayList<>();

    /**
     * Crée un compte avec l'identifiant donné et un solde initial à 0.
     */
    public Account(Long id) {
        this.id = id;
        this.balance = 0;
    }

    public Long getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
} 
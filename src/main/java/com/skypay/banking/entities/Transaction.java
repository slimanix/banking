package com.skypay.banking.entities;

import java.time.LocalDate;

/**
 * Représente une transaction bancaire (dépôt ou retrait) avec la date, le montant et le solde après l'opération.
 */
public class Transaction {
    // Date de la transaction
    private LocalDate date;
    // Montant de la transaction (positif pour un dépôt, négatif pour un retrait)
    private int amount;
    // Solde du compte après la transaction
    private int balanceAfter;

    /**
     * Crée une transaction avec la date, le montant et le solde après opération.
     */
    public Transaction(LocalDate date, int amount, int balanceAfter) {
        this.date = date;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalanceAfter() {
        return balanceAfter;
    }
} 
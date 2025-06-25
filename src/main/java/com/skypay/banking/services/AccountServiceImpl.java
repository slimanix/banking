package com.skypay.banking.services;

import com.skypay.banking.entities.Account;
import com.skypay.banking.entities.Transaction;
import com.skypay.banking.exceptions.account.AccountException;
import com.skypay.banking.models.AccountService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Implémentation de la logique métier pour la gestion des comptes bancaires.
 * Les comptes et transactions sont stockés en mémoire (Map).
 */
public class AccountServiceImpl implements AccountService {
    // Map des comptes bancaires, indexés par leur identifiant
    private final Map<Long, Account> accounts = new HashMap<>();

    /**
     * Récupère un compte existant ou le crée s'il n'existe pas.
     */
    public Account getOrCreateAccount(Long accountId) {
        return accounts.computeIfAbsent(accountId, Account::new);
    }

    /**
     * Effectue un dépôt sur le compte.
     */
    @Override
    public void deposit(Long accountId, int amount) {
        if (amount <= 0) throw new AccountException("Deposit amount must be positive");
        Account account = getOrCreateAccount(accountId);
        account.setBalance(account.getBalance() + amount);
        account.getTransactions().add(new Transaction(LocalDate.now(), amount, account.getBalance()));
    }

    /**
     * Effectue un retrait sur le compte.
     */
    @Override
    public void withdraw(Long accountId, int amount) {
        if (amount <= 0) throw new AccountException("Withdraw amount must be positive");
        Account account = getOrCreateAccount(accountId);
        if (amount > account.getBalance()) throw new AccountException("Insufficient funds");
        account.setBalance(account.getBalance() - amount);
        account.getTransactions().add(new Transaction(LocalDate.now(), -amount, account.getBalance()));
    }

    /**
     * Génère le relevé bancaire du compte, formaté en String.
     */
    @Override
    public String printStatement(Long accountId) {
        Account account = getOrCreateAccount(accountId);
        List<Transaction> reversed = new ArrayList<>(account.getTransactions());
        Collections.reverse(reversed);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Date       || Amount || Balance\n");
        for (Transaction t : reversed) {
            sb.append(String.format("%s || %d || %d\n",
                    t.getDate().format(formatter),
                    t.getAmount(),
                    t.getBalanceAfter()));
        }
        return sb.toString();
    }
} 
package com.skypay.banking.models;

/**
 * Interface métier définissant les opérations possibles sur un compte bancaire.
 */
public interface AccountService {
    /**
     * Effectue un dépôt sur le compte spécifié.
     * @param accountId identifiant du compte
     * @param amount montant à déposer
     */
    void deposit(Long accountId, int amount);

    /**
     * Effectue un retrait sur le compte spécifié.
     * @param accountId identifiant du compte
     * @param amount montant à retirer
     */
    void withdraw(Long accountId, int amount);

    /**
     * Génère le relevé bancaire du compte spécifié.
     * @param accountId identifiant du compte
     * @return relevé formaté en String
     */
    String printStatement(Long accountId);
} 
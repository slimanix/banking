package com.skypay.banking.controllers;

import com.skypay.banking.dto.AnswerDTO;
import com.skypay.banking.dto.DepositRequestDTO;
import com.skypay.banking.dto.ReponseStatementDTO;
import com.skypay.banking.dto.WithdrawRequestDTO;
import com.skypay.banking.models.AccountService;
import com.skypay.banking.services.AccountServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * Contrôleur REST pour la gestion des comptes bancaires.
 * Expose les endpoints pour déposer, retirer et afficher le relevé.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
    // Service métier pour la gestion des comptes
    private final AccountService accountService = new AccountServiceImpl();

    /**
     * Endpoint pour effectuer un dépôt sur un compte.
     * @param id identifiant du compte
     * @param request DTO contenant le montant à déposer
     * @return message de succès
     */
    @PostMapping("/{id}/deposit")
    public AnswerDTO deposit(@PathVariable Long id, @RequestBody DepositRequestDTO request) {
        accountService.deposit(id, request.getAmount());
        return new AnswerDTO("Deposit successful");
    }

    /**
     * Endpoint pour effectuer un retrait sur un compte.
     * @param id identifiant du compte
     * @param request DTO contenant le montant à retirer
     * @return message de succès
     */
    @PostMapping("/{id}/withdraw")
    public AnswerDTO withdraw(@PathVariable Long id, @RequestBody WithdrawRequestDTO request) {
        accountService.withdraw(id, request.getAmount());
        return new AnswerDTO("Withdraw successful");
    }

    /**
     * Endpoint pour afficher le relevé bancaire d'un compte.
     * @param id identifiant du compte
     * @return DTO contenant les lignes du relevé
     */
    @GetMapping("/{id}/statement")
    public ReponseStatementDTO printStatement(@PathVariable Long id) {
        String statement = accountService.printStatement(id);
        return new ReponseStatementDTO(Arrays.asList(statement.split("\n")));
    }
} 